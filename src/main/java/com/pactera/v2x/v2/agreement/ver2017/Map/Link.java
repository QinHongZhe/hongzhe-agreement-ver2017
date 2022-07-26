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
 * 定义路段。从一个节点到相邻另一个节点的道路称为一个有向路段。其属性包含名称、上游节
 * 点ID、限速集合、车道宽度,以及该路段包含的车道集合与交通标志标牌集合。
 */
public class Link {
  @Null
  @Component(0)
  public String name;
  
  @NotNull
  @Component(1)
  public NodeReferenceID upstreamNodeId;
  
  @Null
  @Component(2)
  public Vector<RegulatorySpeedLimit> speedLimits;
  
  @NotNull
  @Component(3)
  public Integer laneWidth;
  
  @Null
  @Component(4)
  public Vector<RoadPoint> points;
  
  @Null
  @Component(5)
  public Vector<Movement> movements;
  
  @NotNull
  @Component(6)
  public Vector<Lane> lanes;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof Link))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Link per_decode(boolean align, InputStream in) throws IOException {
    return (Link)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = Map.type(327694);
  
  public static final CompositeConverter CONV = new AnnotationCompositeConverter(Link.class);
  
  static {
    AsnConverter nameConverter = DescriptiveName.CONV;
    CompositeConverter compositeConverter = NodeReferenceID.CONV;
    AsnConverter speedLimitsConverter = SpeedLimitList.CONV;
    AsnConverter laneWidthConverter = LaneWidth.CONV;
    AsnConverter pointsConverter = PointList.CONV;
    AsnConverter movementsConverter = MovementList.CONV;
    AsnConverter lanesConverter = LaneList.CONV;
    CONV.setComponentConverters(new AsnConverter[] { nameConverter, compositeConverter, speedLimitsConverter, laneWidthConverter, pointsConverter, movementsConverter, lanesConverter });
  }
}
