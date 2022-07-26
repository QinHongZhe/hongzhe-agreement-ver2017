package com.pactera.v2x.v2.agreement.ver2017.DefPositionOffset;

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
 * 36比特相对经纬度位置,表示当前位置点关于参考位置点的经纬度偏差。由两个18比特的经度
 * 韦度偏差值组成。
 */
public class Position_LL_36B {
  @NotNull
  @Component(0)
  public Integer lon;
  
  @NotNull
  @Component(1)
  public Integer lat;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof Position_LL_36B))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static Position_LL_36B per_decode(boolean align, InputStream in) throws IOException {
    return (Position_LL_36B)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = DefPositionOffset.type(65544);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(Position_LL_36B.class);
  
  static {
    AsnConverter lonConverter = OffsetLL_B18.CONV;
    AsnConverter latConverter = OffsetLL_B18.CONV;
    CONV.setComponentConverters(new AsnConverter[] { lonConverter, latConverter });
  }
}
