package com.pactera.v2x.v2.agreement.ver2017.VehSafetyExt;

import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 定义车辆的预测线路、主要是预测线路的曲率半径。
 */
public class PathPrediction {
  @NotNull
  @Component(0)
  public Integer radiusOfCurve;
  
  @NotNull
  @Component(1)
  public Integer confidence;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof PathPrediction))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static PathPrediction per_decode(boolean align, InputStream in) throws IOException {
    return (PathPrediction)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = VehSafetyExt.type(327735);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(PathPrediction.class);
  
  static {
    AsnConverter radiusOfCurveConverter = RadiusOfCurvature.CONV;
    AsnConverter confidenceConverter = Confidence.CONV;
    CONV.setComponentConverters(new AsnConverter[] { radiusOfCurveConverter, confidenceConverter });
  }
}
