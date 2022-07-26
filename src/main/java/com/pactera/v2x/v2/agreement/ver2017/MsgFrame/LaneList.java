package com.pactera.v2x.v2.agreement.ver2017.MsgFrame;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.VectorConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

/**
 * 定义一个路段中包含的车道列表。
 */
public class LaneList {
  public static void per_encode(Vector<Lane> object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Vector<Lane> per_decode(boolean align, InputStream in) throws IOException {
    return (Vector<Lane>)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = MsgFrame.type(1114211);
  
  public static final AsnConverter CONV = (AsnConverter)new VectorConverter((AsnConverter)Lane.CONV);
}
