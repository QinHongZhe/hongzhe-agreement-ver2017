package com.pactera.v2x.v2.agreement.ver2017.VehSize;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.IntegerConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * 定义车辆车身长度。分辨率为1cm。数值0表示无效数据。
 */
public class VehicleLength {
  public static void per_encode(Integer object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Integer per_decode(boolean align, InputStream in) throws IOException {
    return (Integer)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = VehSize.type(65538);
  
  public static final AsnConverter CONV = (AsnConverter) IntegerConverter.INSTANCE;
}
