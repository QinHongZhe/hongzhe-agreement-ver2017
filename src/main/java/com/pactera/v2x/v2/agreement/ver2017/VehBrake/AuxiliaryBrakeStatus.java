package com.pactera.v2x.v2.agreement.ver2017.VehBrake;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionEnumeratedConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 指示刹车辅助系统状态(通常为手刹)。
 */
public enum AuxiliaryBrakeStatus {
  unavailable(0),
  off(1),
  on(2),
  reserved(3);
  
  private int value;
  
  public static final AsnType TYPE;
  
  public static final AsnConverter CONV;
  
  AuxiliaryBrakeStatus(int value) {
    this.value = value;
  }
  
  public int value() {
    return this.value;
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static AuxiliaryBrakeStatus per_decode(boolean align, InputStream in) throws IOException {
    return (AuxiliaryBrakeStatus)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  static {
    TYPE = VehBrake.type(65543);
    CONV = (AsnConverter)new ReflectionEnumeratedConverter(AuxiliaryBrakeStatus.class);
  }
}
