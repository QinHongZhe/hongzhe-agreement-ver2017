package com.pactera.v2x.v2.agreement.ver2017.MsgFrame;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.IntegerConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 车辆横摆角速度。指汽车绕垂直轴的偏转,该偏转的大小代表汽车的稳定程度。如果偏转角速
 * 度达到一个國值,说明汽车处于发生测滑或者甩尾等的危险工况。顺时针旋转为正,逆时针为负
 * 数据分辨率为0.01°/s。
 */
public class YawRate {
  public static void per_encode(Integer object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Integer per_decode(boolean align, InputStream in) throws IOException {
    return (Integer)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = MsgFrame.type(458774);
  
  public static final AsnConverter CONV = (AsnConverter) IntegerConverter.INSTANCE;
}
