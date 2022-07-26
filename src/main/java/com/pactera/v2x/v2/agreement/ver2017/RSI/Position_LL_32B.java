package com.pactera.v2x.v2.agreement.ver2017.RSI;

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
 * 32比特相对经纬度位置,表示当前位置点关于参考位置点的经纬度偏差。由两个16比特的经度
 */
public class Position_LL_32B {
  @NotNull
  @Component(0)
  public Integer lon;
  
  @NotNull
  @Component(1)
  public Integer lat;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof Position_LL_32B))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Position_LL_32B per_decode(boolean align, InputStream in) throws IOException {
    return (Position_LL_32B)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = RSI.type(131081);
  
  public static final CompositeConverter CONV = new AnnotationCompositeConverter(Position_LL_32B.class);
  
  static {
    AsnConverter lonConverter = OffsetLL_B16.CONV;
    AsnConverter latConverter = OffsetLL_B16.CONV;
    CONV.setComponentConverters(new AsnConverter[] { lonConverter, latConverter });
  }
}