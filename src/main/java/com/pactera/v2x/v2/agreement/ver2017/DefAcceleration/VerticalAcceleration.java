package com.pactera.v2x.v2.agreement.ver2017.DefAcceleration;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.IntegerConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 定义Z轴方向的加速度大小,Z轴方向竖直向下,沿着Z轴方向为正。分辦率为0.02g,g为
 * 重力加速度典型值9.80665m/s2
 */
public class VerticalAcceleration {
  public static void per_encode(Integer object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Integer per_decode(boolean align, InputStream in) throws IOException {
    return (Integer)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = DefAcceleration.type(65538);
  
  public static final AsnConverter CONV = (AsnConverter) IntegerConverter.INSTANCE;
}
