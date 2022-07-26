package com.pactera.v2x.v2.agreement.ver2017.VehBrake;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionEnumeratedConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 定义牵引力控制系统实时状态。具体定义如下:
 * Unavailable:系统未装备或不可用;
 * Om:系统处于关闭状态
 * On:系统处于开启状态,但未触发;
 * Engaged:系统被触发,处于作用状态。
 */
public enum TractionControlStatus {
  unavailable(0),
  off(1),
  on(2),
  engaged(3);
  
  private int value;
  
  public static final AsnType TYPE;
  
  public static final AsnConverter CONV;
  
  TractionControlStatus(int value) {
    this.value = value;
  }
  
  public int value() {
    return this.value;
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static TractionControlStatus per_decode(boolean align, InputStream in) throws IOException {
    return (TractionControlStatus)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  static {
    TYPE = VehBrake.type(65539);
    CONV = (AsnConverter)new ReflectionEnumeratedConverter(TractionControlStatus.class);
  }
}
