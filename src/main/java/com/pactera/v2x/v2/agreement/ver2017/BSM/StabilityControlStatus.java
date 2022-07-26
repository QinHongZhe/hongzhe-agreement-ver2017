package com.pactera.v2x.v2.agreement.ver2017.BSM;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionEnumeratedConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 定义车辆动态稳定控制系统状态。具体定义如下:
 * Unavailable:系统未装备或不可用
 * Of:系统处于关闭状态
 * Om:系统处于开启状态,但未触发;
 * Engaged:系统被触发,处于作用状态。
 */
public enum StabilityControlStatus {
  unavailable(0),
  off(1),
  on(2),
  engaged(3);
  
  private int value;
  
  public static final AsnType TYPE;
  
  public static final AsnConverter CONV;
  
  StabilityControlStatus(int value) {
    this.value = value;
  }
  
  public int value() {
    return this.value;
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static StabilityControlStatus per_decode(boolean align, InputStream in) throws IOException {
    return (StabilityControlStatus)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  static {
    TYPE = BSM.type(458779);
    CONV = new ReflectionEnumeratedConverter(StabilityControlStatus.class);
  }
}
