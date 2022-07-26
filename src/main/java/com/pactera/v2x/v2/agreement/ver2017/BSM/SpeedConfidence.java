package com.pactera.v2x.v2.agreement.ver2017.BSM;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionEnumeratedConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 数值描述了95%置信水平的车速精度。该精度理论上只考虑了当前车速传感器的误差。但当
 * 系统能够自动检测锴误并修正时,相应的精度数值也应该提高。
 */
public enum SpeedConfidence {
  unavailable(0),
  prec100ms(1),
  prec10ms(2),
  prec5ms(3),
  prec1ms(4),
  prec0_1ms(5),
  prec0_05ms(6),
  prec0_01ms(7);
  
  private int value;
  
  public static final AsnType TYPE;
  
  public static final AsnConverter CONV;
  
  SpeedConfidence(int value) {
    this.value = value;
  }
  
  public int value() {
    return this.value;
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static SpeedConfidence per_decode(boolean align, InputStream in) throws IOException {
    return (SpeedConfidence)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  static {
    TYPE = BSM.type(327695);
    CONV = new ReflectionEnumeratedConverter(SpeedConfidence.class);
  }
}
