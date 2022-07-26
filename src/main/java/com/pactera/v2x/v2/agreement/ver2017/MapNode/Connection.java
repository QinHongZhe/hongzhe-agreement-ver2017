package com.pactera.v2x.v2.agreement.ver2017.MapNode;

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
 *
 * 定义车道与下游路段车道的连接关系。包括下游路段出口节点D、连接的下游路段车道基本
 * 信息以及对应的信号灯相位号。在车道连接中定义的相位号,是对 DF Movement中定义转向的相位
 * 号的一个补充。当某一些车道在转向时需要参考一些特殊的信号灯相位(而不是 DF Movement中
 * 义的默认相位),则应该将其定义在本数据帧中
 */
public class Connection {
  @NotNull
  @Component(0)
  public NodeReferenceID remoteIntersection;
  
  @Null
  @Component(1)
  public ConnectingLane connectingLane;
  
  @Null
  @Component(2)
  public Integer phaseId;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof Connection))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static Connection per_decode(boolean align, InputStream in) throws IOException {
    return (Connection)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = MapNode.type(393275);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(Connection.class);
  
  static {
    CompositeConverter compositeConverter1 = NodeReferenceID.CONV;
    CompositeConverter compositeConverter2 = ConnectingLane.CONV;
    AsnConverter phaseIdConverter = PhaseID.CONV;
    CONV.setComponentConverters(new AsnConverter[] { (AsnConverter)compositeConverter1, (AsnConverter)compositeConverter2, phaseIdConverter });
  }
}
