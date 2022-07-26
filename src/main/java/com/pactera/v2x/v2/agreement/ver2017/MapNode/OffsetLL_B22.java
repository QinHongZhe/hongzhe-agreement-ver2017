package com.pactera.v2x.v2.agreement.ver2017.MapNode;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.IntegerConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 22比特数值,表示当前位置点关于参考位置点的经纬度偏差。值得注意的是,根据纬度的不同
 * 相同的经纬度偏差值对应的实际球面距离可能不同。
 * 关于参考点,向东或向北偏移,数值为正,反之为负。分辨率为1e-7。
 */
public class OffsetLL_B22 {
  public static void per_encode(Integer object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Integer per_decode(boolean align, InputStream in) throws IOException {
    return (Integer)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = MapNode.type(524317);
  
  public static final AsnConverter CONV = (AsnConverter) IntegerConverter.INSTANCE;
}
