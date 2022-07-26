package com.pactera.v2x.v2.agreement.ver2017.MapNode;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.VectorConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

/**
 * 描述一条路段与下游路段的连接关系列表。
 */
public class MovementList {
  public static void per_encode(Vector<Movement> object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Vector<Movement> per_decode(boolean align, InputStream in) throws IOException {
    return (Vector<Movement>)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = MapNode.type(196648);
  
  public static final AsnConverter CONV = (AsnConverter)new VectorConverter((AsnConverter)Movement.CONV);
}
