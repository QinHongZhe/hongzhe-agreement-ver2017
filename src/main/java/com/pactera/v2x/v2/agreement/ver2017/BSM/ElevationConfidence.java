package com.pactera.v2x.v2.agreement.ver2017.BSM;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionEnumeratedConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 数值描述了95%置信水平的车辆高程精度。该精度理论上只考虑了当前高程传感器的误差
 * 但当系统能够自动检測错误并修正时,相应的精度数值也应该提高
 */
public enum ElevationConfidence {
  unavailable(0),
  elev_500_00(1),
  elev_200_00(2),
  elev_100_00(3),
  elev_050_00(4),
  elev_020_00(5),
  elev_010_00(6),
  elev_005_00(7),
  elev_002_00(8),
  elev_001_00(9),
  elev_000_50(10),
  elev_000_20(11),
  elev_000_10(12),
  elev_000_05(13),
  elev_000_02(14),
  elev_000_01(15);
  
  private int value;
  
  public static final AsnType TYPE;
  
  public static final AsnConverter CONV;
  
  ElevationConfidence(int value) {
    this.value = value;
  }
  
  public int value() {
    return this.value;
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static ElevationConfidence per_decode(boolean align, InputStream in) throws IOException {
    return (ElevationConfidence)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  static {
    TYPE = BSM.type(196617);
    CONV = new ReflectionEnumeratedConverter(ElevationConfidence.class);
  }
}
