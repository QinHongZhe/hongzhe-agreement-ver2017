package com.pactera.v2x.v2.agreement.ver2017.MsgFrame;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionEnumeratedConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 路侧单元检测到的交通参与者类型。
 */
public enum ParticipantType {
  unknown(0),
  motor(1),
  non_motor(2),
  pedestrian(3),
  rsu(4);
  
  private int value;
  
  public static final AsnType TYPE;
  
  public static final AsnConverter CONV;
  
  ParticipantType(int value) {
    this.value = value;
  }
  
  public int value() {
    return this.value;
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static ParticipantType per_decode(boolean align, InputStream in) throws IOException {
    return (ParticipantType)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  static {
    TYPE = MsgFrame.type(1310840);
    CONV = (AsnConverter)new ReflectionEnumeratedConverter(ParticipantType.class);
  }
}
