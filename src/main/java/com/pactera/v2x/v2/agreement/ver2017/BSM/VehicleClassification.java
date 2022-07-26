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
 * 定义车辆的分类,可从各个维度对车辆类型进行定义。目前仅有车辆基本类型一项。
 */
public class VehicleClassification {
  @NotNull
  @Component(0)
  public Integer classification;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof VehicleClassification))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static VehicleClassification per_decode(boolean align, InputStream in) throws IOException {
    return (VehicleClassification)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = BSM.type(589858);
  
  public static final CompositeConverter CONV = new AnnotationCompositeConverter(VehicleClassification.class);
  
  static {
    AsnConverter classificationConverter = BasicVehicleClass.CONV;
    CONV.setComponentConverters(new AsnConverter[] { classificationConverter });
  }
}
