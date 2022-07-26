package com.pactera.v2x.v2.agreement.ver2017.VehBrake;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionBitStringConverter;
import org.asnlab.asndt.runtime.type.AsnType;
import org.asnlab.asndt.runtime.value.BitString;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 定义四轮分别的刹车状态。这里将车辆的轮胎分为左前、右前、左后、右后四组。当车辆进行
 * 刹车时,该数值分别指示了四组轮胎的刹车情况。
 * 当车辆为单排轮胎(摩托车等)时,分别以左前和左后表示其前、后轮,后侧轮胎对应数值置
 * 为0。当车辆某一组轮胎由多个组成时,其状态将等效为一个数值来表示。
 */
public class BrakeAppliedStatus extends BitString {
  public static final int unavailable = 0;
  
  public static final int leftFront = 1;
  
  public static final int leftRear = 2;
  
  public static final int rightFront = 3;
  
  public static final int rightRear = 4;
  
  public BrakeAppliedStatus(byte[] bytes, byte unusedBits) {
    super(bytes, unusedBits);
  }
  
  public BrakeAppliedStatus(int size) {
    super(size);
  }
  
  public BrakeAppliedStatus() {
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
  
  public boolean getLeftFront() {
    return getBit(1);
  }
  
  public void setLeftFront() {
    setBit(1, true);
  }
  
  public void clearLeftFront() {
    setBit(1, false);
  }
  
  public boolean getLeftRear() {
    return getBit(2);
  }
  
  public void setLeftRear() {
    setBit(2, true);
  }
  
  public void clearLeftRear() {
    setBit(2, false);
  }
  
  public boolean getRightFront() {
    return getBit(3);
  }
  
  public void setRightFront() {
    setBit(3, true);
  }
  
  public void clearRightFront() {
    setBit(3, false);
  }
  
  public boolean getRightRear() {
    return getBit(4);
  }
  
  public void setRightRear() {
    setBit(4, true);
  }
  
  public void clearRightRear() {
    setBit(4, false);
  }
  
  public boolean equals(Object obj) {
    if (!(obj instanceof BrakeAppliedStatus))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static BrakeAppliedStatus per_decode(boolean align, InputStream in) throws IOException {
    return (BrakeAppliedStatus)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = VehBrake.type(65538);
  
  public static final AsnConverter CONV = (AsnConverter)new ReflectionBitStringConverter(BrakeAppliedStatus.class);
}
