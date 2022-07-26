package com.pactera.v2x.v2.agreement.ver2017.MapLink;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionBitStringConverter;
import org.asnlab.asndt.runtime.type.AsnType;
import org.asnlab.asndt.runtime.value.BitString;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 车辆行驶车道的属性定义。用来描述一条车用车道的特殊属性和其允许行驶的汽车种类
 */
public class LaneAttributes_Vehicle extends BitString {
  public static final int isVehicleRevocableLane = 0;
  
  public static final int isVehicleFlyOverLane = 1;
  
  public static final int hovLaneUseOnly = 2;
  
  public static final int restrictedToBusUse = 3;
  
  public static final int restrictedToTaxiUse = 4;
  
  public static final int restrictedFromPublicUse = 5;
  
  public static final int hasIRbeaconCoverage = 6;
  
  public static final int permissionOnRequest = 7;
  
  public LaneAttributes_Vehicle(byte[] bytes, byte unusedBits) {
    super(bytes, unusedBits);
  }
  
  public LaneAttributes_Vehicle(int size) {
    super(size);
  }
  
  public LaneAttributes_Vehicle() {
    super(0);
  }
  
  public boolean getIsVehicleRevocableLane() {
    return getBit(0);
  }
  
  public void setIsVehicleRevocableLane() {
    setBit(0, true);
  }
  
  public void clearIsVehicleRevocableLane() {
    setBit(0, false);
  }
  
  public boolean getIsVehicleFlyOverLane() {
    return getBit(1);
  }
  
  public void setIsVehicleFlyOverLane() {
    setBit(1, true);
  }
  
  public void clearIsVehicleFlyOverLane() {
    setBit(1, false);
  }
  
  public boolean getHovLaneUseOnly() {
    return getBit(2);
  }
  
  public void setHovLaneUseOnly() {
    setBit(2, true);
  }
  
  public void clearHovLaneUseOnly() {
    setBit(2, false);
  }
  
  public boolean getRestrictedToBusUse() {
    return getBit(3);
  }
  
  public void setRestrictedToBusUse() {
    setBit(3, true);
  }
  
  public void clearRestrictedToBusUse() {
    setBit(3, false);
  }
  
  public boolean getRestrictedToTaxiUse() {
    return getBit(4);
  }
  
  public void setRestrictedToTaxiUse() {
    setBit(4, true);
  }
  
  public void clearRestrictedToTaxiUse() {
    setBit(4, false);
  }
  
  public boolean getRestrictedFromPublicUse() {
    return getBit(5);
  }
  
  public void setRestrictedFromPublicUse() {
    setBit(5, true);
  }
  
  public void clearRestrictedFromPublicUse() {
    setBit(5, false);
  }
  
  public boolean getHasIRbeaconCoverage() {
    return getBit(6);
  }
  
  public void setHasIRbeaconCoverage() {
    setBit(6, true);
  }
  
  public void clearHasIRbeaconCoverage() {
    setBit(6, false);
  }
  
  public boolean getPermissionOnRequest() {
    return getBit(7);
  }
  
  public void setPermissionOnRequest() {
    setBit(7, true);
  }
  
  public void clearPermissionOnRequest() {
    setBit(7, false);
  }
  
  public boolean equals(Object obj) {
    if (!(obj instanceof LaneAttributes_Vehicle))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static LaneAttributes_Vehicle per_decode(boolean align, InputStream in) throws IOException {
    return (LaneAttributes_Vehicle)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = MapLink.type(393262);
  
  public static final AsnConverter CONV = (AsnConverter)new ReflectionBitStringConverter(LaneAttributes_Vehicle.class);
}
