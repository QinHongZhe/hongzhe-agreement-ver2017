package com.pactera.v2x.v2.agreement.ver2017.RSM;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionEnumeratedConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 定义路侧交通参与者数据的检测器来源。
 */
public enum SourceType {
  unknown(0),
  selfinfo(1),
  v2x(2),
  video(3),
  microwaveRadar(4),
  loop(5);
  
  private int value;
  
  public static final AsnType TYPE;
  
  public static final AsnConverter CONV;
  
  SourceType(int value) {
    this.value = value;
  }
  
  public int value() {
    return this.value;
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static SourceType per_decode(boolean align, InputStream in) throws IOException {
    return (SourceType)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  static {
    TYPE = RSM.type(65538);
    CONV = new ReflectionEnumeratedConverter(SourceType.class);
  }
}
