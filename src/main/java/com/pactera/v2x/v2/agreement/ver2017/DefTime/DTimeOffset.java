package com.pactera.v2x.v2.agreement.ver2017.DefTime;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.IntegerConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 定义和UTC时间的分钟差,用来表示时区。比UTC快为正,否则为负。
 */
public class DTimeOffset {
  public static void per_encode(Integer object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Integer per_decode(boolean align, InputStream in) throws IOException {
    return (Integer)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = DefTime.type(65543);
  
  public static final AsnConverter CONV = (AsnConverter) IntegerConverter.INSTANCE;
}
