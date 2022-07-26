package com.pactera.v2x.v2.agreement.ver2017.VehSafetyExt;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.IntegerConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 10毫秒为单位,定义当前描述时刻(较早)相对于参考时间点(较晚)的偏差。用于车辆
 * 历史轨迹点的表达。分辨率为10毫秒。数值65535表示无效数据。
 */
public class TimeOffset {
  public static void per_encode(Integer object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Integer per_decode(boolean align, InputStream in) throws IOException {
    return (Integer)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = VehSafetyExt.type(65584);
  
  public static final AsnConverter CONV = (AsnConverter) IntegerConverter.INSTANCE;
}
