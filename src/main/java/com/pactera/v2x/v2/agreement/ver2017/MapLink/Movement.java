package com.pactera.v2x.v2.agreement.ver2017.MapLink;

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
 * 描述道路与下游路段的连接关系以及该连接对应的本地路口处信号灯相位D
 * 此处的相位1D事实上也是MAP消息与SPAT消息的唯一关联。车辆在确定转向行为后,能够
 * 通过该相位ID数据,査看到SPAT中对应的相位实时状态,从而获得行车过程中的信号灯数据辅助。
 */
public class Movement {
  @NotNull
  @Component(0)
  public NodeReferenceID remoteIntersection;
  
  @Null
  @Component(1)
  public Integer phaseId;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof Movement))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static Movement per_decode(boolean align, InputStream in) throws IOException {
    return (Movement)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = MapLink.type(196613);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(Movement.class);
  
  static {
    CompositeConverter compositeConverter = NodeReferenceID.CONV;
    AsnConverter phaseIdConverter = PhaseID.CONV;
    CONV.setComponentConverters(new AsnConverter[] { (AsnConverter)compositeConverter, phaseIdConverter });
  }
}
