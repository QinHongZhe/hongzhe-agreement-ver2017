package com.pactera.v2x.v2.agreement.ver2017.MsgFrame;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionBitStringConverter;
import org.asnlab.asndt.runtime.type.AsnType;
import org.asnlab.asndt.runtime.value.BitString;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 路口信号机的工作状态指示。用于SPAT消息中。
 */
public class IntersectionStatusObject extends BitString {
  public static final int manualControlIsEnabled = 0;
  
  public static final int stopTimeIsActivated = 1;
  
  public static final int failureFlash = 2;
  
  public static final int preemptIsActive = 3;
  
  public static final int signalPriorityIsActive = 4;
  
  public static final int fixedTimeOperation = 5;
  
  public static final int trafficDependentOperation = 6;
  
  public static final int standbyOperation = 7;
  
  public static final int failureMode = 8;
  
  public static final int off = 9;
  
  public static final int recentMAPmessageUpdate = 10;
  
  public static final int recentChangeInMAPassignedLanesIDsUsed = 11;
  
  public static final int noValidMAPisAvailableAtThisTime = 12;
  
  public static final int noValidSPATisAvailableAtThisTime = 13;
  
  public IntersectionStatusObject(byte[] bytes, byte unusedBits) {
    super(bytes, unusedBits);
  }
  
  public IntersectionStatusObject(int size) {
    super(size);
  }
  
  public IntersectionStatusObject() {
    super(0);
  }
  
  public boolean getManualControlIsEnabled() {
    return getBit(0);
  }
  
  public void setManualControlIsEnabled() {
    setBit(0, true);
  }
  
  public void clearManualControlIsEnabled() {
    setBit(0, false);
  }
  
  public boolean getStopTimeIsActivated() {
    return getBit(1);
  }
  
  public void setStopTimeIsActivated() {
    setBit(1, true);
  }
  
  public void clearStopTimeIsActivated() {
    setBit(1, false);
  }
  
  public boolean getFailureFlash() {
    return getBit(2);
  }
  
  public void setFailureFlash() {
    setBit(2, true);
  }
  
  public void clearFailureFlash() {
    setBit(2, false);
  }
  
  public boolean getPreemptIsActive() {
    return getBit(3);
  }
  
  public void setPreemptIsActive() {
    setBit(3, true);
  }
  
  public void clearPreemptIsActive() {
    setBit(3, false);
  }
  
  public boolean getSignalPriorityIsActive() {
    return getBit(4);
  }
  
  public void setSignalPriorityIsActive() {
    setBit(4, true);
  }
  
  public void clearSignalPriorityIsActive() {
    setBit(4, false);
  }
  
  public boolean getFixedTimeOperation() {
    return getBit(5);
  }
  
  public void setFixedTimeOperation() {
    setBit(5, true);
  }
  
  public void clearFixedTimeOperation() {
    setBit(5, false);
  }
  
  public boolean getTrafficDependentOperation() {
    return getBit(6);
  }
  
  public void setTrafficDependentOperation() {
    setBit(6, true);
  }
  
  public void clearTrafficDependentOperation() {
    setBit(6, false);
  }
  
  public boolean getStandbyOperation() {
    return getBit(7);
  }
  
  public void setStandbyOperation() {
    setBit(7, true);
  }
  
  public void clearStandbyOperation() {
    setBit(7, false);
  }
  
  public boolean getFailureMode() {
    return getBit(8);
  }
  
  public void setFailureMode() {
    setBit(8, true);
  }
  
  public void clearFailureMode() {
    setBit(8, false);
  }
  
  public boolean getOff() {
    return getBit(9);
  }
  
  public void setOff() {
    setBit(9, true);
  }
  
  public void clearOff() {
    setBit(9, false);
  }
  
  public boolean getRecentMAPmessageUpdate() {
    return getBit(10);
  }
  
  public void setRecentMAPmessageUpdate() {
    setBit(10, true);
  }
  
  public void clearRecentMAPmessageUpdate() {
    setBit(10, false);
  }
  
  public boolean getRecentChangeInMAPassignedLanesIDsUsed() {
    return getBit(11);
  }
  
  public void setRecentChangeInMAPassignedLanesIDsUsed() {
    setBit(11, true);
  }
  
  public void clearRecentChangeInMAPassignedLanesIDsUsed() {
    setBit(11, false);
  }
  
  public boolean getNoValidMAPisAvailableAtThisTime() {
    return getBit(12);
  }
  
  public void setNoValidMAPisAvailableAtThisTime() {
    setBit(12, true);
  }
  
  public void clearNoValidMAPisAvailableAtThisTime() {
    setBit(12, false);
  }
  
  public boolean getNoValidSPATisAvailableAtThisTime() {
    return getBit(13);
  }
  
  public void setNoValidSPATisAvailableAtThisTime() {
    setBit(13, true);
  }
  
  public void clearNoValidSPATisAvailableAtThisTime() {
    setBit(13, false);
  }
  
  public boolean equals(Object obj) {
    if (!(obj instanceof IntersectionStatusObject))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static IntersectionStatusObject per_decode(boolean align, InputStream in) throws IOException {
    return (IntersectionStatusObject)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = MsgFrame.type(1245309);
  
  public static final AsnConverter CONV = (AsnConverter)new ReflectionBitStringConverter(IntersectionStatusObject.class);
}
