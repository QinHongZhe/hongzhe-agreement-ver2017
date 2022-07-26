package com.pactera.v2x.v2.agreement.ver2017.RSI;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.IntegerConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 表示一个特定圆形范围的半径大小,如一个交通事件基于圆心参考位置点的作用范围。数值主
 * 要用于RSA消息。分辨率为10cm
 */
public class Radius {
  public static void per_encode(Integer object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Integer per_decode(boolean align, InputStream in) throws IOException {
    return (Integer)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = RSI.type(65565);
  
  public static final AsnConverter CONV = IntegerConverter.INSTANCE;
}
