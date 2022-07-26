package com.pactera.v2x.v2.agreement.ver2017.MsgFrame;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionEnumeratedConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 数值描述了95%置信水平的时间精度。该精度理论上只考虑了当前计时系统本身传感器的误差
 * 但当系统能够自动檢測错误并修正时,相应的精度数值也应该提高。
 */
public enum TimeConfidence {
  unavailable(0),
  time_100_000(1),
  time_050_000(2),
  time_020_000(3),
  time_010_000(4),
  time_002_000(5),
  time_001_000(6),
  time_000_500(7),
  time_000_200(8),
  time_000_100(9),
  time_000_050(10),
  time_000_020(11),
  time_000_010(12),
  time_000_005(13),
  time_000_002(14),
  time_000_001(15),
  time_000_000_5(16),
  time_000_000_2(17),
  time_000_000_1(18),
  time_000_000_05(19),
  time_000_000_02(20),
  time_000_000_01(21),
  time_000_000_005(22),
  time_000_000_002(23),
  time_000_000_001(24),
  time_000_000_000_5(25),
  time_000_000_000_2(26),
  time_000_000_000_1(27),
  time_000_000_000_05(28),
  time_000_000_000_02(29),
  time_000_000_000_01(30),
  time_000_000_000_005(31),
  time_000_000_000_002(32),
  time_000_000_000_001(33),
  time_000_000_000_000_5(34),
  time_000_000_000_000_2(35),
  time_000_000_000_000_1(36),
  time_000_000_000_000_05(37),
  time_000_000_000_000_02(38),
  time_000_000_000_000_01(39);
  
  private int value;
  
  public static final AsnType TYPE;
  
  public static final AsnConverter CONV;
  
  TimeConfidence(int value) {
    this.value = value;
  }
  
  public int value() {
    return this.value;
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static TimeConfidence per_decode(boolean align, InputStream in) throws IOException {
    return (TimeConfidence)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  static {
    TYPE = MsgFrame.type(196656);
    CONV = (AsnConverter)new ReflectionEnumeratedConverter(TimeConfidence.class);
  }
}
