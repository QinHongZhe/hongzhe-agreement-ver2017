package com.pactera.v2x.v2.agreement.ver2017.MapLink;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionBitStringConverter;
import org.asnlab.asndt.runtime.type.AsnType;
import org.asnlab.asndt.runtime.value.BitString;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 车道隔离的属性定义。主要指示车道隔离的物理形式。
 */
public class LaneAttributes_Barrier extends BitString {
  public static final int median_RevocableLane = 0;
  
  public static final int median = 1;
  
  public static final int whiteLineHashing = 2;
  
  public static final int stripedLines = 3;
  
  public static final int doubleStripedLines = 4;
  
  public static final int trafficCones = 5;
  
  public static final int constructionBarrier = 6;
  
  public static final int trafficChannels = 7;
  
  public static final int lowCurbs = 8;
  
  public static final int highCurbs = 9;
  
  public LaneAttributes_Barrier(byte[] bytes, byte unusedBits) {
    super(bytes, unusedBits);
  }
  
  public LaneAttributes_Barrier(int size) {
    super(size);
  }
  
  public LaneAttributes_Barrier() {
    super(0);
  }
  
  public boolean getMedian_RevocableLane() {
    return getBit(0);
  }
  
  public void setMedian_RevocableLane() {
    setBit(0, true);
  }
  
  public void clearMedian_RevocableLane() {
    setBit(0, false);
  }
  
  public boolean getMedian() {
    return getBit(1);
  }
  
  public void setMedian() {
    setBit(1, true);
  }
  
  public void clearMedian() {
    setBit(1, false);
  }
  
  public boolean getWhiteLineHashing() {
    return getBit(2);
  }
  
  public void setWhiteLineHashing() {
    setBit(2, true);
  }
  
  public void clearWhiteLineHashing() {
    setBit(2, false);
  }
  
  public boolean getStripedLines() {
    return getBit(3);
  }
  
  public void setStripedLines() {
    setBit(3, true);
  }
  
  public void clearStripedLines() {
    setBit(3, false);
  }
  
  public boolean getDoubleStripedLines() {
    return getBit(4);
  }
  
  public void setDoubleStripedLines() {
    setBit(4, true);
  }
  
  public void clearDoubleStripedLines() {
    setBit(4, false);
  }
  
  public boolean getTrafficCones() {
    return getBit(5);
  }
  
  public void setTrafficCones() {
    setBit(5, true);
  }
  
  public void clearTrafficCones() {
    setBit(5, false);
  }
  
  public boolean getConstructionBarrier() {
    return getBit(6);
  }
  
  public void setConstructionBarrier() {
    setBit(6, true);
  }
  
  public void clearConstructionBarrier() {
    setBit(6, false);
  }
  
  public boolean getTrafficChannels() {
    return getBit(7);
  }
  
  public void setTrafficChannels() {
    setBit(7, true);
  }
  
  public void clearTrafficChannels() {
    setBit(7, false);
  }
  
  public boolean getLowCurbs() {
    return getBit(8);
  }
  
  public void setLowCurbs() {
    setBit(8, true);
  }
  
  public void clearLowCurbs() {
    setBit(8, false);
  }
  
  public boolean getHighCurbs() {
    return getBit(9);
  }
  
  public void setHighCurbs() {
    setBit(9, true);
  }
  
  public void clearHighCurbs() {
    setBit(9, false);
  }
  
  public boolean equals(Object obj) {
    if (!(obj instanceof LaneAttributes_Barrier))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static LaneAttributes_Barrier per_decode(boolean align, InputStream in) throws IOException {
    return (LaneAttributes_Barrier)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = MapLink.type(393266);
  
  public static final AsnConverter CONV = (AsnConverter)new ReflectionBitStringConverter(LaneAttributes_Barrier.class);
}
