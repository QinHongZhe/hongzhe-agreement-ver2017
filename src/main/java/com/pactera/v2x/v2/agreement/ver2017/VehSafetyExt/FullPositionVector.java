package com.pactera.v2x.v2.agreement.ver2017.VehSafetyExt;

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
 * 定义完整的参考轨迹点信息。用于车辆历史轨迹数据单元,作为一串轨迹点的参考点数据
 */
public class FullPositionVector {
  @Null
  @Component(0)
  public DDateTime utcTime;
  
  @NotNull
  @Component(1)
  public Position3D pos;
  
  @Null
  @Component(2)
  public Integer heading;
  
  @Null
  @Component(3)
  public TransmissionState transmission;
  
  @Null
  @Component(4)
  public Integer speed;
  
  @Null
  @Component(5)
  public PositionConfidenceSet posAccuracy;
  
  @Null
  @Component(6)
  public TimeConfidence timeConfidence;
  
  @Null
  @Component(7)
  public PositionConfidenceSet posConfidence;
  
  @Null
  @Component(8)
  public MotionConfidenceSet motionCfd;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof FullPositionVector))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static FullPositionVector per_decode(boolean align, InputStream in) throws IOException {
    return (FullPositionVector)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = VehSafetyExt.type(327704);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(FullPositionVector.class);
  
  static {
    CompositeConverter compositeConverter1 = DDateTime.CONV;
    CompositeConverter compositeConverter2 = Position3D.CONV;
    AsnConverter headingConverter = Heading.CONV;
    AsnConverter transmissionConverter = TransmissionState.CONV;
    AsnConverter speedConverter = Speed.CONV;
    CompositeConverter compositeConverter3 = PositionConfidenceSet.CONV;
    AsnConverter timeConfidenceConverter = TimeConfidence.CONV;
    CompositeConverter compositeConverter4 = PositionConfidenceSet.CONV;
    CompositeConverter compositeConverter5 = MotionConfidenceSet.CONV;
    CONV.setComponentConverters(new AsnConverter[] { (AsnConverter)compositeConverter1, (AsnConverter)compositeConverter2, headingConverter, transmissionConverter, speedConverter, (AsnConverter)compositeConverter3, timeConfidenceConverter, (AsnConverter)compositeConverter4, (AsnConverter)compositeConverter5 });
  }
}
