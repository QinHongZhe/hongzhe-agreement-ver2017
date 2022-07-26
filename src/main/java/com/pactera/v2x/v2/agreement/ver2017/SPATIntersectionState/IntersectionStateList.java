package com.pactera.v2x.v2.agreement.ver2017.SPATIntersectionState;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.VectorConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

/**
 * 定义一个路口信号灯集合。
 */
public class IntersectionStateList {
  public static void per_encode(Vector<IntersectionState> object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Vector<IntersectionState> per_decode(boolean align, InputStream in) throws IOException {
    return (Vector<IntersectionState>)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = SPATIntersectionState.type(65553);
  
  public static final AsnConverter CONV = (AsnConverter)new VectorConverter((AsnConverter)IntersectionState.CONV);
}
