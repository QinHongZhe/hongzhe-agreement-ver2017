package com.pactera.v2x.v2.agreement.ver2017.VehSafetyExt;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.VectorConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

/**
 * 定义车辆的历史轨迹点列表
 * 该轨迹由一系列轨迹点组成。能够精准地给出车辆完整的历史行驶轨迹,可以以当前时刻运动
 * 状态为基准,也可以是一段时间之前的轨迹
 */
public class PathHistoryPointList {
  public static void per_encode(Vector<PathHistoryPoint> object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Vector<PathHistoryPoint> per_decode(boolean align, InputStream in) throws IOException {
    return (Vector<PathHistoryPoint>)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = VehSafetyExt.type(327731);
  
  public static final AsnConverter CONV = (AsnConverter)new VectorConverter((AsnConverter)PathHistoryPoint.CONV);
}
