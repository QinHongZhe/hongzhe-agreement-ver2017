package com.pactera.v2x.v2.agreement.ver2017.MapLane;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.IntegerConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 定义经度数值。东经为正,西经为负。分辨率为1e-7°。
 */
public class Longitude {
  public static void per_encode(Integer object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Integer per_decode(boolean align, InputStream in) throws IOException {
    return (Integer)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = MapLane.type(524330);
  
  public static final AsnConverter CONV = (AsnConverter) IntegerConverter.INSTANCE;
}
