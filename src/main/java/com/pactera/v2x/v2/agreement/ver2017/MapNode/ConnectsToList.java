package com.pactera.v2x.v2.agreement.ver2017.MapNode;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.VectorConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

/**
 * 定义路段中每条车道在下游路口处与下游路段车道的转向连接关系列表。
 */
public class ConnectsToList {
  public static void per_encode(Vector<Connection> object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Vector<Connection> per_decode(boolean align, InputStream in) throws IOException {
    return (Vector<Connection>)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = MapNode.type(393274);
  
  public static final AsnConverter CONV = (AsnConverter)new VectorConverter((AsnConverter)Connection.CONV);
}
