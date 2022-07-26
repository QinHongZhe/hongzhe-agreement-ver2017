package com.pactera.v2x.v2.agreement.ver2017.MsgFrame;

import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 定义车辆尺寸大小。由车辆长、宽、高三个维度来定义,其中高度数值为可选项。
 */
public class VehicleSize {
  @NotNull
  @Component(0)
  public Integer width;
  
  @NotNull
  @Component(1)
  public Integer length;
  
  @Null
  @Component(2)
  public Integer height;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof VehicleSize))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static VehicleSize per_decode(boolean align, InputStream in) throws IOException {
    return (VehicleSize)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = MsgFrame.type(589855);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(VehicleSize.class);
  
  static {
    AsnConverter widthConverter = VehicleWidth.CONV;
    AsnConverter lengthConverter = VehicleLength.CONV;
    AsnConverter heightConverter = VehicleHeight.CONV;
    CONV.setComponentConverters(new AsnConverter[] { widthConverter, lengthConverter, heightConverter });
  }
}
