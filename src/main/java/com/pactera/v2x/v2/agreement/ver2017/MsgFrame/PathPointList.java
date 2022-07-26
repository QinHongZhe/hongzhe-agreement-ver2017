package com.pactera.v2x.v2.agreement.ver2017.MsgFrame;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.VectorConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

/**
 * 定义RSA消息中,消息作用范围的车辆行进轨迹区段。该区段由有序位置点列组成,排列顺
 * 序与车辆行进方向一致
 */
public class PathPointList {
  public static void per_encode(Vector<PositionOffsetLLV> object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Vector<PositionOffsetLLV> per_decode(boolean align, InputStream in) throws IOException {
    return (Vector<PositionOffsetLLV>)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = MsgFrame.type(1441928);
  
  public static final AsnConverter CONV = (AsnConverter)new VectorConverter((AsnConverter)PositionOffsetLLV.CONV);
}
