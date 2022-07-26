package com.pactera.v2x.v2.agreement.ver2017.SPATIntersectionState;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionEnumeratedConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 信号灯某一相位的灯色状态。具体定义如下
 * Unavailable:未知状态
 * Dak:信号灯未工作;
 * stop-Then- Proceed:红闪;
 * stp-And- Remain:红灯状态
 * pre- Movement:绿灯待行状态(红末闪烁)
 * permissive- Movement- Allowed:绿灯状态
 * protected- Movement-- Allowed:受保护相位绿灯(箭头灯
 * tersection- Clearance:黄灯状态;
 * caution- Conflicting- Traffic:黄闪
 */

public enum LightState {
  unavailable(0),
  dark(1),
  stop_Then_Proceed(2),
  stop_And_Remain(3),
  pre_Movement(4),
  permissive_Movement_Allowed(5),
  protected_Movement_Allowed(6),
  intersection_clearance(7),
  caution_Conflicting_Traffic(8);
  
  private int value;
  
  public static final AsnType TYPE;
  
  public static final AsnConverter CONV;
  
  LightState(int value) {
    this.value = value;
  }
  
  public int value() {
    return this.value;
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static LightState per_decode(boolean align, InputStream in) throws IOException {
    return (LightState)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  static {
    TYPE = SPATIntersectionState.type(65539);
    CONV = (AsnConverter)new ReflectionEnumeratedConverter(LightState.class);
  }
}
