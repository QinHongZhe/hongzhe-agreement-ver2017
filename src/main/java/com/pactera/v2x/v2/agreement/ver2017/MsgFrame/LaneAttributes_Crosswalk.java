package com.pactera.v2x.v2.agreement.ver2017.MsgFrame;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionBitStringConverter;
import org.asnlab.asndt.runtime.type.AsnType;
import org.asnlab.asndt.runtime.value.BitString;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 人行横道的属性定义。指示车道的一系列通过属性和人行辅助设施
 */
public class LaneAttributes_Crosswalk extends BitString {
  public static final int crosswalkRevocableLane = 0;
  
  public static final int bicyleUseAllowed = 1;
  
  public static final int isXwalkFlyOverLane = 2;
  
  public static final int fixedCycleTime = 3;
  
  public static final int biDirectionalCycleTimes = 4;
  
  public static final int hasPushToWalkButton = 5;
  
  public static final int audioSupport = 6;
  
  public static final int rfSignalRequestPresent = 7;
  
  public static final int unsignalizedSegmentsPresent = 8;
  
  public LaneAttributes_Crosswalk(byte[] bytes, byte unusedBits) {
    super(bytes, unusedBits);
  }
  
  public LaneAttributes_Crosswalk(int size) {
    super(size);
  }
  
  public LaneAttributes_Crosswalk() {
    super(0);
  }
  
  public boolean getCrosswalkRevocableLane() {
    return getBit(0);
  }
  
  public void setCrosswalkRevocableLane() {
    setBit(0, true);
  }
  
  public void clearCrosswalkRevocableLane() {
    setBit(0, false);
  }
  
  public boolean getBicyleUseAllowed() {
    return getBit(1);
  }
  
  public void setBicyleUseAllowed() {
    setBit(1, true);
  }
  
  public void clearBicyleUseAllowed() {
    setBit(1, false);
  }
  
  public boolean getIsXwalkFlyOverLane() {
    return getBit(2);
  }
  
  public void setIsXwalkFlyOverLane() {
    setBit(2, true);
  }
  
  public void clearIsXwalkFlyOverLane() {
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
  
  public boolean getHasPushToWalkButton() {
    return getBit(5);
  }
  
  public void setHasPushToWalkButton() {
    setBit(5, true);
  }
  
  public void clearHasPushToWalkButton() {
    setBit(5, false);
  }
  
  public boolean getAudioSupport() {
    return getBit(6);
  }
  
  public void setAudioSupport() {
    setBit(6, true);
  }
  
  public void clearAudioSupport() {
    setBit(6, false);
  }
  
  public boolean getRfSignalRequestPresent() {
    return getBit(7);
  }
  
  public void setRfSignalRequestPresent() {
    setBit(7, true);
  }
  
  public void clearRfSignalRequestPresent() {
    setBit(7, false);
  }
  
  public boolean getUnsignalizedSegmentsPresent() {
    return getBit(8);
  }
  
  public void setUnsignalizedSegmentsPresent() {
    setBit(8, true);
  }
  
  public void clearUnsignalizedSegmentsPresent() {
    setBit(8, false);
  }
  
  public boolean equals(Object obj) {
    if (!(obj instanceof LaneAttributes_Crosswalk))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static LaneAttributes_Crosswalk per_decode(boolean align, InputStream in) throws IOException {
    return (LaneAttributes_Crosswalk)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = MsgFrame.type(1114218);
  
  public static final AsnConverter CONV = (AsnConverter)new ReflectionBitStringConverter(LaneAttributes_Crosswalk.class);
}
