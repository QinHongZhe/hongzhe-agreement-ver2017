package com.pactera.v2x.v2.agreement.ver2017.MapPoint;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.VectorConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

/**
 * 定义一个有向路段上的中间位置点列表,用来表达路段上截面或片段的特殊属性。列表中所有
 * 置点需按上游至下游顺序排列
 */
public class PointList {
  public static void per_encode(Vector<RoadPoint> object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Vector<RoadPoint> per_decode(boolean align, InputStream in) throws IOException {
    return (Vector<RoadPoint>)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = MapPoint.type(196635);
  
  public static final AsnConverter CONV = (AsnConverter)new VectorConverter((AsnConverter)RoadPoint.CONV);
}
