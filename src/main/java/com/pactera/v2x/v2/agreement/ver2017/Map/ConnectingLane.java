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

/**
 * 用于定位上游车道转向连接的下游车道,包括车道ID以及该转向的允许行驶行为。这里下
 * 游车道ID的作用范围是其所在的路段
 */
public class ConnectingLane {
  @NotNull
  @Component(0)
  public Integer lane;

  /**
   * 定义一个(机动车)车道的允许转向行为。
   */
  @Null
  @Component(1)
  public AllowedManeuvers maneuver;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof ConnectingLane))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static ConnectingLane per_decode(boolean align, InputStream in) throws IOException {
    return (ConnectingLane)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = Map.type(524352);
  
  public static final CompositeConverter CONV = new AnnotationCompositeConverter(ConnectingLane.class);
  
  static {
    AsnConverter laneConverter = LaneID.CONV;
    AsnConverter maneuverConverter = AllowedManeuvers.CONV;
    CONV.setComponentConverters(new AsnConverter[] { laneConverter, maneuverConverter });
  }
}
