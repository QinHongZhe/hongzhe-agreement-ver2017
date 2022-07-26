package com.pactera.v2x.v2.agreement.ver2017.MsgFrame;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionEnumeratedConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 定义车辆档位状态。具体定义如下
 * Neutral:空档;
 * Park:停止档;
 * Forwardgears:前进档
 * Reversegears:倒档。
 */
public enum TransmissionState {
  neutral(0),
  park(1),
  forwardGears(2),
  reverseGears(3),
  reserved1(4),
  reserved2(5),
  reserved3(6),
  unavailable(7);
  
  private int value;
  
  public static final AsnType TYPE;
  
  public static final AsnConverter CONV;
  
  TransmissionState(int value) {
    this.value = value;
  }
  
  public int value() {
    return this.value;
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static TransmissionState per_decode(boolean align, InputStream in) throws IOException {
    return (TransmissionState)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  static {
    TYPE = MsgFrame.type(327691);
    CONV = (AsnConverter)new ReflectionEnumeratedConverter(TransmissionState.class);
  }
}
