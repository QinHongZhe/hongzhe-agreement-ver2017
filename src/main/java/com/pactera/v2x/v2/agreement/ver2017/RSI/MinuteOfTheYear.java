package com.pactera.v2x.v2.agreement.ver2017.RSI;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.IntegerConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 数值用来表示当前年份,已经过去的总分钟数(UTC时间)。分率为1分钟。该数值配合
 * Second数值,则可表示全年已过去的总毫秒数
 */
public class MinuteOfTheYear {
  public static void per_encode(Integer object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Integer per_decode(boolean align, InputStream in) throws IOException {
    return (Integer)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = RSI.type(327711);
  
  public static final AsnConverter CONV = IntegerConverter.INSTANCE;
}
