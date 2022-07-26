package com.pactera.v2x.v2.agreement.ver2017.RSI;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.IntegerConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 8比特的数据,定义垂直方向(Z轴)关于参考位置点的偏差。沿着Z轴方向为正。数据分辨
 * 率为10cm。-128数值表示未知大小。
 */
public class VertOffset_B08 {
  public static void per_encode(Integer object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Integer per_decode(boolean align, InputStream in) throws IOException {
    return (Integer)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = RSI.type(131094);
  
  public static final AsnConverter CONV = IntegerConverter.INSTANCE;
}
