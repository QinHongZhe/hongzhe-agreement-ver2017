package com.pactera.v2x.v2.agreement.ver2017.BSM;

import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

import javax.validation.constraints.Null;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 车辆的刹车系统状态
 */
public class BrakeSystemStatus {
  /**
   * 刹车踏板踩下情况
   */
  @Null
  @Component(0)
  public BrakePedalStatus brakePadel;

  /**
   * 车辆车轮制动情况
   */
  @Null
  @Component(1)
  public BrakeAppliedStatus wheelBrakes;

  /**
   * 牵引力控制系统作用情况
   */
  @Null
  @Component(2)
  public TractionControlStatus traction;

  /**
   * 制动防抱死系统作用情况
   */
  @Null
  @Component(3)
  public AntiLockBrakeStatus abs;

  /**
   * 车身稳定控制系统作用情况
   */
  @Null
  @Component(4)
  public StabilityControlStatus scs;

  /**
   * 刹车助力系统作用情况
   */
  @Null
  @Component(5)
  public BrakeBoostApplied brakeBoost;

  /**
   * 辅助制动系统（一般指手刹）情况
   */
  @Null
  @Component(6)
  public AuxiliaryBrakeStatus auxBrakes;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof BrakeSystemStatus))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static BrakeSystemStatus per_decode(boolean align, InputStream in) throws IOException {
    return (BrakeSystemStatus)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = BSM.type(458774);
  
  public static final CompositeConverter CONV = new AnnotationCompositeConverter(BrakeSystemStatus.class);
  
  static {
    AsnConverter brakePadelConverter = BrakePedalStatus.CONV;
    AsnConverter wheelBrakesConverter = BrakeAppliedStatus.CONV;
    AsnConverter tractionConverter = TractionControlStatus.CONV;
    AsnConverter absConverter = AntiLockBrakeStatus.CONV;
    AsnConverter scsConverter = StabilityControlStatus.CONV;
    AsnConverter brakeBoostConverter = BrakeBoostApplied.CONV;
    AsnConverter auxBrakesConverter = AuxiliaryBrakeStatus.CONV;
    CONV.setComponentConverters(new AsnConverter[] { brakePadelConverter, wheelBrakesConverter, tractionConverter, absConverter, scsConverter, brakeBoostConverter, auxBrakesConverter });
  }
}
