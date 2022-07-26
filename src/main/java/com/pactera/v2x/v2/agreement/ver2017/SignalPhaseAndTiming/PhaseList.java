package com.pactera.v2x.v2.agreement.ver2017.SignalPhaseAndTiming;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.VectorConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

/**
 * 定义一组信号灯包含的所有相位的列表。
 */
public class PhaseList {
  public static void per_encode(Vector<Phase> object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Vector<Phase> per_decode(boolean align, InputStream in) throws IOException {
    return (Vector<Phase>)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = SignalPhaseAndTiming.type(262155);
  
  public static final AsnConverter CONV = (AsnConverter)new VectorConverter((AsnConverter)Phase.CONV);
}
