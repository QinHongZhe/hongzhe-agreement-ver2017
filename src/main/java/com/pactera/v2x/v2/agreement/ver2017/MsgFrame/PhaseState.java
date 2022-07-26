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
 * 定义信号灯的一个相位状态。包含该状态对应的灯色,以及实时计时信息
 */
public class PhaseState {
  @NotNull
  @Component(0)
  public LightState light;
  
  @Null
  @Component(1)
  public TimeChangeDetails timing;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof PhaseState))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static PhaseState per_decode(boolean align, InputStream in) throws IOException {
    return (PhaseState)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = MsgFrame.type(1245313);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(PhaseState.class);
  
  static {
    AsnConverter lightConverter = LightState.CONV;
    CompositeConverter compositeConverter = TimeChangeDetails.CONV;
    CONV.setComponentConverters(new AsnConverter[] { lightConverter, (AsnConverter)compositeConverter });
  }
}
