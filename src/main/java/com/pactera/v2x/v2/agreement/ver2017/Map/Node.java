package com.pactera.v2x.v2.agreement.ver2017.Map;

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
 *
 * 地图节点。节点是地图的最基本组成部分,可以是交叉路口,也可以是一个路段的端点。在地
 * 图上,相邻且有序的两个节点确定一条有向路段
 * 节点属性包括名称、ID、位置以及与节点相连的上游路段集合
 * 节点数据帧中包含的路段列表,均以该节点作为下游端点。而以该节点为上游端点的路段,则
 * 归属于该路段下游节点的数据帧
 */
public class Node {
  @Null
  @Component(0)
  public String name;
  
  @NotNull
  @Component(1)
  public NodeReferenceID id;
  
  @NotNull
  @Component(2)
  public Position3D refPos;
  
  @Null
  @Component(3)
  public Vector<Link> inLinks;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof Node))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Node per_decode(boolean align, InputStream in) throws IOException {
    return (Node)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = Map.type(196612);
  
  public static final CompositeConverter CONV = new AnnotationCompositeConverter(Node.class);
  
  static {
    AsnConverter nameConverter = DescriptiveName.CONV;
    CompositeConverter compositeConverter1 = NodeReferenceID.CONV;
    CompositeConverter compositeConverter2 = Position3D.CONV;
    AsnConverter inLinksConverter = LinkList.CONV;
    CONV.setComponentConverters(new AsnConverter[] { nameConverter, compositeConverter1, compositeConverter2, inLinksConverter });
  }
}
