package com.pactera.v2x.v2.agreement.ver2017.DefTime;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.IntegerConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 定义1天中的小时时刻。有效范围是0~23。24及以上表示未知或无效。
 */
public class DHour {
  public static void per_encode(Integer object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Integer per_decode(boolean align, InputStream in) throws IOException {
    return (Integer)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = DefTime.type(65541);
  
  public static final AsnConverter CONV = (AsnConverter) IntegerConverter.INSTANCE;
}
