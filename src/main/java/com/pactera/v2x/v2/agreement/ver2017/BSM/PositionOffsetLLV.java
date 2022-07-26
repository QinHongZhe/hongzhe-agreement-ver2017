package com.pactera.v2x.v2.agreement.ver2017.BSM;

import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ChoiceConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 定义三维的相对位置(相对经纬度和相对高程)。
 */
public class PositionOffsetLLV {
  @NotNull
  @Component(0)
  public PositionOffsetLL offsetLL;
  
  @Null
  @Component(1)
  public VerticalOffset offsetV;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof PositionOffsetLLV))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static PositionOffsetLLV per_decode(boolean align, InputStream in) throws IOException {
    return (PositionOffsetLLV)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = BSM.type(720947);
  
  public static final CompositeConverter CONV = new AnnotationCompositeConverter(PositionOffsetLLV.class);
  
  static {
    ChoiceConverter choiceConverter1 = PositionOffsetLL.CONV;
    ChoiceConverter choiceConverter2 = VerticalOffset.CONV;
    CONV.setComponentConverters(new AsnConverter[] {choiceConverter1, choiceConverter2});
  }
}
