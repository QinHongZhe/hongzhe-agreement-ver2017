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
 * 64比特经纬度位置。该尺度采用了真实经纬度数据进行描述,非相对位置。
 */
public class Position_LLmD_64b {
  @NotNull
  @Component(0)
  public Integer lon;
  
  @NotNull
  @Component(1)
  public Integer lat;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof Position_LLmD_64b))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Position_LLmD_64b per_decode(boolean align, InputStream in) throws IOException {
    return (Position_LLmD_64b)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = RSI.type(131089);
  
  public static final CompositeConverter CONV = new AnnotationCompositeConverter(Position_LLmD_64b.class);
  
  static {
    AsnConverter lonConverter = Longitude.CONV;
    AsnConverter latConverter = Latitude.CONV;
    CONV.setComponentConverters(new AsnConverter[] { lonConverter, latConverter });
  }
}
