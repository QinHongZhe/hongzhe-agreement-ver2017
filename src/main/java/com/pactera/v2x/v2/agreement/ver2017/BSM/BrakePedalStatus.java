package com.pactera.v2x.v2.agreement.ver2017.BSM;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionEnumeratedConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 指示刹车踏板状态,即是否处在被踩下状态。
 */
public enum BrakePedalStatus {
  unavailable(0),
  off(1),
  on(2);
  
  private int value;
  
  public static final AsnType TYPE;
  
  public static final AsnConverter CONV;
  
  BrakePedalStatus(int value) {
    this.value = value;
  }
  
  public int value() {
    return this.value;
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static BrakePedalStatus per_decode(boolean align, InputStream in) throws IOException {
    return (BrakePedalStatus)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  static {
    TYPE = BSM.type(458775);
    CONV = new ReflectionEnumeratedConverter(BrakePedalStatus.class);
  }
}
