package com.pactera.v2x.v2.agreement.ver2017.MsgFrame;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionBitStringConverter;
import org.asnlab.asndt.runtime.type.AsnType;
import org.asnlab.asndt.runtime.value.BitString;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 定义GNSS系统工作状态。包括设备工作状态、锁星情況和修正信息等。GNSS系统可以是
 * CPS、北斗等相关系统和设备
 */
public class GNSSstatus extends BitString {
  public static final int unavailable = 0;
  
  public static final int isHealthy = 1;
  
  public static final int isMonitored = 2;
  
  public static final int baseStationType = 3;
  
  public static final int aPDOPofUnder5 = 4;
  
  public static final int inViewOfUnder5 = 5;
  
  public static final int localCorrectionsPresent = 6;
  
  public static final int networkCorrectionsPresent = 7;
  
  public GNSSstatus(byte[] bytes, byte unusedBits) {
    super(bytes, unusedBits);
  }
  
  public GNSSstatus(int size) {
    super(size);
  }
  
  public GNSSstatus() {
    super(0);
  }
  
  public boolean getUnavailable() {
    return getBit(0);
  }
  
  public void setUnavailable() {
    setBit(0, true);
  }
  
  public void clearUnavailable() {
    setBit(0, false);
  }
  
  public boolean getIsHealthy() {
    return getBit(1);
  }
  
  public void setIsHealthy() {
    setBit(1, true);
  }
  
  public void clearIsHealthy() {
    setBit(1, false);
  }
  
  public boolean getIsMonitored() {
    return getBit(2);
  }
  
  public void setIsMonitored() {
    setBit(2, true);
  }
  
  public void clearIsMonitored() {
    setBit(2, false);
  }
  
  public boolean getBaseStationType() {
    return getBit(3);
  }
  
  public void setBaseStationType() {
    setBit(3, true);
  }
  
  public void clearBaseStationType() {
    setBit(3, false);
  }
  
  public boolean getAPDOPofUnder5() {
    return getBit(4);
  }
  
  public void setAPDOPofUnder5() {
    setBit(4, true);
  }
  
  public void clearAPDOPofUnder5() {
    setBit(4, false);
  }
  
  public boolean getInViewOfUnder5() {
    return getBit(5);
  }
  
  public void setInViewOfUnder5() {
    setBit(5, true);
  }
  
  public void clearInViewOfUnder5() {
    setBit(5, false);
  }
  
  public boolean getLocalCorrectionsPresent() {
    return getBit(6);
  }
  
  public void setLocalCorrectionsPresent() {
    setBit(6, true);
  }
  
  public void clearLocalCorrectionsPresent() {
    setBit(6, false);
  }
  
  public boolean getNetworkCorrectionsPresent() {
    return getBit(7);
  }
  
  public void setNetworkCorrectionsPresent() {
    setBit(7, true);
  }
  
  public void clearNetworkCorrectionsPresent() {
    setBit(7, false);
  }
  
  public boolean equals(Object obj) {
    if (!(obj instanceof GNSSstatus))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static GNSSstatus per_decode(boolean align, InputStream in) throws IOException {
    return (GNSSstatus)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = MsgFrame.type(720945);
  
  public static final AsnConverter CONV = (AsnConverter)new ReflectionBitStringConverter(GNSSstatus.class);
}
