package com.pactera.v2x.v2.agreement.ver2017.MapLink;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.VectorConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

/**
 * 定义路段列表。
 */
public class LinkList {
  public static void per_encode(Vector<Link> object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Vector<Link> per_decode(boolean align, InputStream in) throws IOException {
    return (Vector<Link>)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = MapLink.type(196667);
  
  public static final AsnConverter CONV = (AsnConverter)new VectorConverter((AsnConverter)Link.CONV);
}
