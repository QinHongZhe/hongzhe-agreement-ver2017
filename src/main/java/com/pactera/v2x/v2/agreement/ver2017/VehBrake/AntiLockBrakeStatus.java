package com.pactera.v2x.v2.agreement.ver2017.VehBrake;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionEnumeratedConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 定义刹车防抱死系统(ABS)状态。
 */
public enum AntiLockBrakeStatus {
  unavailable(0),
  off(1),
  on(2),
  engaged(3);
  
  private int value;
  
  public static final AsnType TYPE;
  
  public static final AsnConverter CONV;
  
  AntiLockBrakeStatus(int value) {
    this.value = value;
  }
  
  public int value() {
    return this.value;
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static AntiLockBrakeStatus per_decode(boolean align, InputStream in) throws IOException {
    return (AntiLockBrakeStatus)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  static {
    TYPE = VehBrake.type(65540);
    CONV = (AsnConverter)new ReflectionEnumeratedConverter(AntiLockBrakeStatus.class);
  }
}
