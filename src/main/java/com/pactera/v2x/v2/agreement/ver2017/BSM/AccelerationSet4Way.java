package com.pactera.v2x.v2.agreement.ver2017.BSM;

import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 车辆四轴加速度
 */
public class AccelerationSet4Way {

  /**
   * 纵向加速度，向前加速为正，反向为负。
   */
  @NotNull
  @Component(0)
  public Integer long_;

  /**
   * 横向加速度，向右加速为正，反向为负
   */
  @NotNull
  @Component(1)
  public Integer lat;

  /**
   * 垂直加速度，沿重力方向向下为正，反向为负
   */
  @NotNull
  @Component(2)
  public Integer vert;

  /**
   * 垂直摆角加速度，顺时针旋转为正，反向为负
   */
  @NotNull
  @Component(3)
  public Integer yaw;

  public boolean equals(Object obj) {
    if (!(obj instanceof AccelerationSet4Way))
      return false;
    return TYPE.equals(this, obj, CONV);
  }

  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }

  public static AccelerationSet4Way per_decode(boolean align, InputStream in) throws IOException {
    return (AccelerationSet4Way)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }

  public static final AsnType TYPE = BSM.type(393234);

  public static final CompositeConverter CONV = new AnnotationCompositeConverter(AccelerationSet4Way.class);

  static {
    AsnConverter long_Converter = Acceleration.CONV;
    AsnConverter latConverter = Acceleration.CONV;
    AsnConverter vertConverter = VerticalAcceleration.CONV;
    AsnConverter yawConverter = YawRate.CONV;
    CONV.setComponentConverters(new AsnConverter[] { long_Converter, latConverter, vertConverter, yawConverter });
  }
}
