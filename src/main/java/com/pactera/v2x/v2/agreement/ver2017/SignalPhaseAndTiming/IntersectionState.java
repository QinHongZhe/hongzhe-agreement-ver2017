package com.pactera.v2x.v2.agreement.ver2017.SignalPhaseAndTiming;

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
import java.util.Vector;

/**
 * 定义一个路口信号灯的属性和当前状态。包括路口ID、信号灯工作状态、时间戳以及信号灯
 * 的相位列表
 */
public class IntersectionState {
  @NotNull
  @Component(0)
  public NodeReferenceID intersectionId;
  
  @NotNull
  @Component(1)
  public IntersectionStatusObject status;
  
  @Null
  @Component(2)
  public Integer moy;
  
  @Null
  @Component(3)
  public Integer timeStamp;
  
  @NotNull
  @Component(4)
  public Vector<Phase> phases;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof IntersectionState))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static IntersectionState per_decode(boolean align, InputStream in) throws IOException {
    return (IntersectionState)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = SignalPhaseAndTiming.type(262149);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(IntersectionState.class);
  
  static {
    CompositeConverter compositeConverter = NodeReferenceID.CONV;
    AsnConverter statusConverter = IntersectionStatusObject.CONV;
    AsnConverter moyConverter = MinuteOfTheYear.CONV;
    AsnConverter timeStampConverter = DSecond.CONV;
    AsnConverter phasesConverter = PhaseList.CONV;
    CONV.setComponentConverters(new AsnConverter[] { (AsnConverter)compositeConverter, statusConverter, moyConverter, timeStampConverter, phasesConverter });
  }
}
