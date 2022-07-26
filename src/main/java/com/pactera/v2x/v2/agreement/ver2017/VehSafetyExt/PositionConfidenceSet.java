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
 * 定义位置(经纬度和高程)的综合精度
 */
public class PositionConfidenceSet {
  @NotNull
  @Component(0)
  public PositionConfidence pos;
  
  @Null
  @Component(1)
  public ElevationConfidence elevation;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof PositionConfidenceSet))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static PositionConfidenceSet per_decode(boolean align, InputStream in) throws IOException {
    return (PositionConfidenceSet)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = VehSafetyExt.type(131088);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(PositionConfidenceSet.class);
  
  static {
    AsnConverter posConverter = PositionConfidence.CONV;
    AsnConverter elevationConverter = ElevationConfidence.CONV;
    CONV.setComponentConverters(new AsnConverter[] { posConverter, elevationConverter });
  }
}
