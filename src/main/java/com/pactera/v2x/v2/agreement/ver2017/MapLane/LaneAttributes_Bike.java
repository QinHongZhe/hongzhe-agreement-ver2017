package com.pactera.v2x.v2.agreement.ver2017.MapLane;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionBitStringConverter;
import org.asnlab.asndt.runtime.type.AsnType;
import org.asnlab.asndt.runtime.value.BitString;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 自行车道的属性定义。
 */
public class LaneAttributes_Bike extends BitString {
  public static final int bikeRevocableLane = 0;
  
  public static final int pedestrianUseAllowed = 1;
  
  public static final int isBikeFlyOverLane = 2;
  
  public static final int fixedCycleTime = 3;
  
  public static final int biDirectionalCycleTimes = 4;
  
  public static final int isolatedByBarrier = 5;
  
  public static final int unsignalizedSegmentsPresent = 6;
  
  public LaneAttributes_Bike(byte[] bytes, byte unusedBits) {
    super(bytes, unusedBits);
  }
  
  public LaneAttributes_Bike(int size) {
    super(size);
  }
  
  public LaneAttributes_Bike() {
    super(0);
  }
  
  public boolean getBikeRevocableLane() {
    return getBit(0);
  }
  
  public void setBikeRevocableLane() {
    setBit(0, true);
  }
  
  public void clearBikeRevocableLane() {
    setBit(0, false);
  }
  
  public boolean getPedestrianUseAllowed() {
    return getBit(1);
  }
  
  public void setPedestrianUseAllowed() {
    setBit(1, true);
  }
  
  public void clearPedestrianUseAllowed() {
    setBit(1, false);
  }
  
  public boolean getIsBikeFlyOverLane() {
    return getBit(2);
  }
  
  public void setIsBikeFlyOverLane() {
    setBit(2, true);
  }
  
  public void clearIsBikeFlyOverLane() {
    setBit(2, false);
  }
  
  public boolean getFixedCycleTime() {
    return getBit(3);
  }
  
  public void setFixedCycleTime() {
    setBit(3, true);
  }
  
  public void clearFixedCycleTime() {
    setBit(3, false);
  }
  
  public boolean getBiDirectionalCycleTimes() {
    return getBit(4);
  }
  
  public void setBiDirectionalCycleTimes() {
    setBit(4, true);
  }
  
  public void clearBiDirectionalCycleTimes() {
    setBit(4, false);
  }
  
  public boolean getIsolatedByBarrier() {
    return getBit(5);
  }
  
  public void setIsolatedByBarrier() {
    setBit(5, true);
  }
  
  public void clearIsolatedByBarrier() {
    setBit(5, false);
  }
  
  public boolean getUnsignalizedSegmentsPresent() {
    return getBit(6);
  }
  
  public void setUnsignalizedSegmentsPresent() {
    setBit(6, true);
  }
  
  public void clearUnsignalizedSegmentsPresent() {
    setBit(6, false);
  }
  
  public boolean equals(Object obj) {
    if (!(obj instanceof LaneAttributes_Bike))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static LaneAttributes_Bike per_decode(boolean align, InputStream in) throws IOException {
    return (LaneAttributes_Bike)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = MapLane.type(65541);
  
  public static final AsnConverter CONV = (AsnConverter)new ReflectionBitStringConverter(LaneAttributes_Bike.class);
}
