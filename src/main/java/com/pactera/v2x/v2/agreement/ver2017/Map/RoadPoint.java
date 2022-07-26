package com.pactera.v2x.v2.agreement.ver2017.Map;

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
 * 表示完整道路上标记的一个位置点属性。包括相对位置、位置点处路段截面的特殊属性集合
 * 以及该位置点到下游相邻位置点之间局部路段的特殊属性集合
 * 如果位置点为路段最下游的点,则其包含的下游截取路段属性为无效数据
 */
public class RoadPoint {
  @NotNull
  @Component(0)
  public PositionOffsetLLV posOffset;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof RoadPoint))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static RoadPoint per_decode(boolean align, InputStream in) throws IOException {
    return (RoadPoint)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = Map.type(589845);
  
  public static final CompositeConverter CONV = new AnnotationCompositeConverter(RoadPoint.class);
  
  static {
    CompositeConverter compositeConverter = PositionOffsetLLV.CONV;
    CONV.setComponentConverters(new AsnConverter[] {compositeConverter});
  }
}
