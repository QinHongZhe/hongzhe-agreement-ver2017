package com.pactera.v2x.v2.agreement.ver2017.Map;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.IntegerConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 定义节点D。路网最基本的构成即节点和连接节点的路段。节点可以是路口,也可以是一条
 * 路的端点。一个节点的D在同一个区域内是唯一的。数值0~255预留为测试使用
 */
public class NodeID {
  public static void per_encode(Integer object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Integer per_decode(boolean align, InputStream in) throws IOException {
    return (Integer)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = Map.type(196616);
  
  public static final AsnConverter CONV = IntegerConverter.INSTANCE;
}
