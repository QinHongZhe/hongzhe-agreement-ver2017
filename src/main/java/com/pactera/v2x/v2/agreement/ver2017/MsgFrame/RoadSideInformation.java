package com.pactera.v2x.v2.agreement.ver2017.MsgFrame;

import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.IntegerConverter;
import org.asnlab.asndt.runtime.conv.OctetStringConverter;
import org.asnlab.asndt.runtime.conv.StringConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

public class RoadSideInformation {
  @NotNull
  @Component(0)
  public Integer msgCnt;
  
  @Null
  @Component(1)
  public Integer timeStamp;
  
  @NotNull
  @Size(min = 8, max = 8)
  @Component(2)
  public byte[] id;
  
  @NotNull
  @Min(0L)
  @Max(255L)
  @Component(3)
  public Integer rsiId;
  
  @NotNull
  @Component(4)
  public Integer alertType;
  
  @Null
  @Component(5)
  public String description;
  
  @Null
  @Component(6)
  public byte[] priority;
  
  @NotNull
  @Component(7)
  public Position3D refPos;
  
  @NotNull
  @Component(8)
  public Vector<PositionOffsetLLV> alertPath;
  
  @NotNull
  @Component(9)
  public Integer alertRadius;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof RoadSideInformation))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static RoadSideInformation per_decode(boolean align, InputStream in) throws IOException {
    return (RoadSideInformation)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = MsgFrame.type(1441925);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(RoadSideInformation.class);
  
  static {
    AsnConverter msgCntConverter = MsgCount.CONV;
    AsnConverter timeStampConverter = MinuteOfTheYear.CONV;
    OctetStringConverter octetStringConverter = OctetStringConverter.INSTANCE;
    IntegerConverter integerConverter = IntegerConverter.INSTANCE;
    AsnConverter alertTypeConverter = AlertType.CONV;
    StringConverter stringConverter = StringConverter.INSTANCE;
    AsnConverter priorityConverter = Priority.CONV;
    CompositeConverter compositeConverter = Position3D.CONV;
    AsnConverter alertPathConverter = PathPointList.CONV;
    AsnConverter alertRadiusConverter = Radius.CONV;
    CONV.setComponentConverters(new AsnConverter[] { msgCntConverter, timeStampConverter, (AsnConverter)octetStringConverter, (AsnConverter)integerConverter, alertTypeConverter, (AsnConverter)stringConverter, priorityConverter, (AsnConverter)compositeConverter, alertPathConverter, alertRadiusConverter });
  }
}
