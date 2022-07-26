package com.pactera.v2x.v2.agreement.ver2017.VehSafetyExt;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.IntegerConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 表示车辆预测自身前方行驶轨迹的曲率半径。数值可能来源于地图数据、曲率传感器、视觉传
 * 感器、定位系统等
 * 分辦率为10cm。轨迹曲线向右偏转(圆心在车辆行驶方向右側)数值为正,向左则为负。数
 * 值32767表示直线行驶
 */
public class RadiusOfCurvature {
  public static void per_encode(Integer object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Integer per_decode(boolean align, InputStream in) throws IOException {
    return (Integer)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = VehSafetyExt.type(327733);
  
  public static final AsnConverter CONV = (AsnConverter) IntegerConverter.INSTANCE;
}
