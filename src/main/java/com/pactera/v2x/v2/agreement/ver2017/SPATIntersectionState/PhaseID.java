package com.pactera.v2x.v2.agreement.ver2017.SPATIntersectionState;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.IntegerConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 定义信号灯相位1D。数值0表示无效1D。
 */
public class PhaseID {
  public static void per_encode(Integer object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Integer per_decode(boolean align, InputStream in) throws IOException {
    return (Integer)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = SPATIntersectionState.type(65538);
  
  public static final AsnConverter CONV = (AsnConverter) IntegerConverter.INSTANCE;
}
