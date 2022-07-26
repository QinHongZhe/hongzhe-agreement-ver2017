package com.pactera.v2x.v2.agreement.ver2017.RSM;

import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

import javax.validation.constraints.Null;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 描述车辆运行状态的精度。包括车速精度、航向精度和方向盘转角精度。
 */
public class MotionConfidenceSet {
  @Null
  @Component(0)
  public SpeedConfidence speedCfd;
  
  @Null
  @Component(1)
  public HeadingConfidence headingCfd;
  
  @Null
  @Component(2)
  public SteeringWheelAngleConfidence steerCfd;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof MotionConfidenceSet))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static MotionConfidenceSet per_decode(boolean align, InputStream in) throws IOException {
    return (MotionConfidenceSet)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = RSM.type(393252);
  
  public static final CompositeConverter CONV = new AnnotationCompositeConverter(MotionConfidenceSet.class);
  
  static {
    AsnConverter speedCfdConverter = SpeedConfidence.CONV;
    AsnConverter headingCfdConverter = HeadingConfidence.CONV;
    AsnConverter steerCfdConverter = SteeringWheelAngleConfidence.CONV;
    CONV.setComponentConverters(new AsnConverter[] { speedCfdConverter, headingCfdConverter, steerCfdConverter });
  }
}