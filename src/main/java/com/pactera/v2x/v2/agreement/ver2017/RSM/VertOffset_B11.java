package com.pactera.v2x.v2.agreement.ver2017.RSM;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.IntegerConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 11比特的数据,定义垂直方向(Z轴)关于参考位置点的偏差。沿着Z轴方向为正。数据分辦
 * 率为10cm。-1024数值表示未知大小
 */
public class VertOffset_B11 {
  public static void per_encode(Integer object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Integer per_decode(boolean align, InputStream in) throws IOException {
    return (Integer)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = RSM.type(196634);
  
  public static final AsnConverter CONV = IntegerConverter.INSTANCE;
}
