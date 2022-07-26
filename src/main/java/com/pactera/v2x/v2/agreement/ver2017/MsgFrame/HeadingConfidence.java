package com.pactera.v2x.v2.agreement.ver2017.MsgFrame;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionEnumeratedConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 数值描述了95%置信水平的车辆航向精度。该精度理论上只考虑了当前航向传感器的误差。
 * 但当系统能够自动检测锴误并修正时,相应的精度数值也应该提高
 */
public enum HeadingConfidence {
  unavailable(0),
  prec10deg(1),
  prec05deg(2),
  prec01deg(3),
  prec0_1deg(4),
  prec0_05deg(5),
  prec0_01deg(6),
  prec0_0125deg(7);
  
  private int value;
  
  public static final AsnType TYPE;
  
  public static final AsnConverter CONV;
  
  HeadingConfidence(int value) {
    this.value = value;
  }
  
  public int value() {
    return this.value;
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static HeadingConfidence per_decode(boolean align, InputStream in) throws IOException {
    return (HeadingConfidence)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  static {
    TYPE = MsgFrame.type(393233);
    CONV = (AsnConverter)new ReflectionEnumeratedConverter(HeadingConfidence.class);
  }
}
