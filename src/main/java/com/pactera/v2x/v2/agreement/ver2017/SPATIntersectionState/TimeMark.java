package com.pactera.v2x.v2.agreement.ver2017.SPATIntersectionState;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.IntegerConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 以0.1秒为单位,定义一小时中的时间。可以表示当前小时中的时刻、也可以表示长度不超过
 * 1小时的时间段
 * 分辦率为0.1秒。有效范围是0~35999。数值36000表示大于1小时的时间长度。数值360
 * 表示无效数值
 */
public class TimeMark {
  public static void per_encode(Integer object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Integer per_decode(boolean align, InputStream in) throws IOException {
    return (Integer)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = SPATIntersectionState.type(131076);
  
  public static final AsnConverter CONV = (AsnConverter) IntegerConverter.INSTANCE;
}
