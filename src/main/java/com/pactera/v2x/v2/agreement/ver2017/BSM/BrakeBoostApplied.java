package com.pactera.v2x.v2.agreement.ver2017.BSM;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionEnumeratedConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 通过刹车辅助系统的状态,指示车辆紧急刹车状态
 * 刹车辅助系统通过对情况的判断,确定是否需要急刹车,进而确定是否需要接管刹车系统,在
 * 驾驶员未来得及做出反应时进行刹车。辅助系统可能通过监测油门踏板的突然松开或前置检测器
 * 来判断紧急刹车的需求
 */
public enum BrakeBoostApplied {
  unavailable(0),
  off(1),
  on(2);
  
  private int value;
  
  public static final AsnType TYPE;
  
  public static final AsnConverter CONV;
  
  BrakeBoostApplied(int value) {
    this.value = value;
  }
  
  public int value() {
    return this.value;
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static BrakeBoostApplied per_decode(boolean align, InputStream in) throws IOException {
    return (BrakeBoostApplied)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  static {
    TYPE = BSM.type(458780);
    CONV = new ReflectionEnumeratedConverter(BrakeBoostApplied.class);
  }
}
