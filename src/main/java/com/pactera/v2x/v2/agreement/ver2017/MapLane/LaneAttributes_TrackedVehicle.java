package com.pactera.v2x.v2.agreement.ver2017.MapLane;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionBitStringConverter;
import org.asnlab.asndt.runtime.type.AsnType;
import org.asnlab.asndt.runtime.value.BitString;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 轨道车辆车道的属性定义。用来描述一条轨道车辆车道的特殊属性和其允许行驶的车辆种类。
 */
public class LaneAttributes_TrackedVehicle extends BitString {
  public static final int spec_RevocableLane = 0;
  
  public static final int spec_commuterRailRoadTrack = 1;
  
  public static final int spec_lightRailRoadTrack = 2;
  
  public static final int spec_heavyRailRoadTrack = 3;
  
  public static final int spec_otherRailType = 4;
  
  public LaneAttributes_TrackedVehicle(byte[] bytes, byte unusedBits) {
    super(bytes, unusedBits);
  }
  
  public LaneAttributes_TrackedVehicle(int size) {
    super(size);
  }
  
  public LaneAttributes_TrackedVehicle() {
    super(0);
  }
  
  public boolean getSpec_RevocableLane() {
    return getBit(0);
  }
  
  public void setSpec_RevocableLane() {
    setBit(0, true);
  }
  
  public void clearSpec_RevocableLane() {
    setBit(0, false);
  }
  
  public boolean getSpec_commuterRailRoadTrack() {
    return getBit(1);
  }
  
  public void setSpec_commuterRailRoadTrack() {
    setBit(1, true);
  }
  
  public void clearSpec_commuterRailRoadTrack() {
    setBit(1, false);
  }
  
  public boolean getSpec_lightRailRoadTrack() {
    return getBit(2);
  }
  
  public void setSpec_lightRailRoadTrack() {
    setBit(2, true);
  }
  
  public void clearSpec_lightRailRoadTrack() {
    setBit(2, false);
  }
  
  public boolean getSpec_heavyRailRoadTrack() {
    return getBit(3);
  }
  
  public void setSpec_heavyRailRoadTrack() {
    setBit(3, true);
  }
  
  public void clearSpec_heavyRailRoadTrack() {
    setBit(3, false);
  }
  
  public boolean getSpec_otherRailType() {
    return getBit(4);
  }
  
  public void setSpec_otherRailType() {
    setBit(4, true);
  }
  
  public void clearSpec_otherRailType() {
    setBit(4, false);
  }
  
  public boolean equals(Object obj) {
    if (!(obj instanceof LaneAttributes_TrackedVehicle))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static LaneAttributes_TrackedVehicle per_decode(boolean align, InputStream in) throws IOException {
    return (LaneAttributes_TrackedVehicle)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = MapLane.type(65545);
  
  public static final AsnConverter CONV = (AsnConverter)new ReflectionBitStringConverter(LaneAttributes_TrackedVehicle.class);
}
