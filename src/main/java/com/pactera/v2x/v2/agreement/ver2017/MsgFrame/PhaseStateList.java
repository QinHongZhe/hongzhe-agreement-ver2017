package com.pactera.v2x.v2.agreement.ver2017.MsgFrame;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.VectorConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

/**
 * 定义一个信号灯的一个相位中的相位状态列表。列表中每一个相位状态物理上对应一种相位灯
 * 色,其属性包括了该状态的实时计时信息
 */
public class PhaseStateList {
  public static void per_encode(Vector<PhaseState> object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Vector<PhaseState> per_decode(boolean align, InputStream in) throws IOException {
    return (Vector<PhaseState>)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = MsgFrame.type(1245312);
  
  public static final AsnConverter CONV = (AsnConverter)new VectorConverter((AsnConverter)PhaseState.CONV);
}
