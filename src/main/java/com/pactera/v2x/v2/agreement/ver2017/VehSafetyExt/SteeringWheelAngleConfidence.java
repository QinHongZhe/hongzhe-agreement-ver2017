package com.pactera.v2x.v2.agreement.ver2017.VehSafetyExt;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionEnumeratedConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 数值描述了95%置信水平的方向盘转角精度。该精度理论上只考虑了当前方向盘转角传感器
 * 的误差。但当系统能够自动检测错误并修正时,相应的精度数值也应该提高。
 */
public enum SteeringWheelAngleConfidence {
  unavailable(0),
  prec2deg(1),
  prec1deg(2),
  prec0_02deg(3);
  
  private int value;
  
  public static final AsnType TYPE;
  
  public static final AsnConverter CONV;
  
  SteeringWheelAngleConfidence(int value) {
    this.value = value;
  }
  
  public int value() {
    return this.value;
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static SteeringWheelAngleConfidence per_decode(boolean align, InputStream in) throws IOException {
    return (SteeringWheelAngleConfidence)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  static {
    TYPE = VehSafetyExt.type(196631);
    CONV = (AsnConverter)new ReflectionEnumeratedConverter(SteeringWheelAngleConfidence.class);
  }
}
