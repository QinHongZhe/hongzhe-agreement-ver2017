package com.pactera.v2x.v2.agreement.ver2017.Map;

import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

/**
 * 定义车道。包含其1D、共享属性、车道出口的允许转向行为、车道与下游路段车道的连接关
 * 系列表,以及车道中间点列表
 */
public class Lane {
  @NotNull
  @Component(0)
  public Integer laneID;
  
  @Null
  @Component(1)
  public LaneAttributes laneAttributes;
  
  @Null
  @Component(2)
  public AllowedManeuvers maneuvers;
  
  @Null
  @Component(3)
  public Vector<Connection> connectsTo;
  
  @Null
  @Component(4)
  public Vector<RegulatorySpeedLimit> speedLimits;
  
  @Null
  @Component(5)
  public Vector<RoadPoint> points;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof Lane))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Lane per_decode(boolean align, InputStream in) throws IOException {
    return (Lane)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = Map.type(524336);
  
  public static final CompositeConverter CONV = new AnnotationCompositeConverter(Lane.class);
  
  static {
    AsnConverter laneIDConverter = LaneID.CONV;
    CompositeConverter compositeConverter = LaneAttributes.CONV;
    AsnConverter maneuversConverter = AllowedManeuvers.CONV;
    AsnConverter connectsToConverter = ConnectsToList.CONV;
    AsnConverter speedLimitsConverter = SpeedLimitList.CONV;
    AsnConverter pointsConverter = PointList.CONV;
    CONV.setComponentConverters(new AsnConverter[] { laneIDConverter, compositeConverter, maneuversConverter, connectsToConverter, speedLimitsConverter, pointsConverter });
  }
}
