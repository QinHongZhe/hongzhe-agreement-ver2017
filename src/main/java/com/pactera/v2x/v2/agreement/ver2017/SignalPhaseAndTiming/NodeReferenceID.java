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

/**
 * 定义参考ID。参考ID由一个全局唯一的地区D和一个地区内部唯一的节点ID组成。
 */
public class NodeReferenceID {
  @Null
  @Component(0)
  public Integer region;
  
  @NotNull
  @Component(1)
  public Integer id;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof NodeReferenceID))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static NodeReferenceID per_decode(boolean align, InputStream in) throws IOException {
    return (NodeReferenceID)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = SignalPhaseAndTiming.type(196614);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(NodeReferenceID.class);
  
  static {
    AsnConverter regionConverter = RoadRegulatorID.CONV;
    AsnConverter idConverter = NodeID.CONV;
    CONV.setComponentConverters(new AsnConverter[] { regionConverter, idConverter });
  }
}
