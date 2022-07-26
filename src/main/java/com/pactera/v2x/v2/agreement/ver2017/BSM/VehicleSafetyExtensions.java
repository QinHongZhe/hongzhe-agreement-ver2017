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
 * 定义车辆安全辅助信息集合。用于BSM消息中,作为基础安全数据的补充。包括车辆特殊事
 * 件状态、车辆历史轨迹、路线预測、车身灯光状态等。各项辅助信息均为可选项
 */
public class VehicleSafetyExtensions {
  @Null
  @Component(0)
  public VehicleEventFlags events;
  
  @Null
  @Component(1)
  public PathHistory pathHistory;
  
  @Null
  @Component(2)
  public PathPrediction pathPrediction;
  
  @Null
  @Component(3)
  public ExteriorLights lights;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof VehicleSafetyExtensions))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static VehicleSafetyExtensions per_decode(boolean align, InputStream in) throws IOException {
    return (VehicleSafetyExtensions)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = BSM.type(655396);
  
  public static final CompositeConverter CONV = new AnnotationCompositeConverter(VehicleSafetyExtensions.class);
  
  static {
    AsnConverter eventsConverter = VehicleEventFlags.CONV;
    CompositeConverter compositeConverter1 = PathHistory.CONV;
    CompositeConverter compositeConverter2 = PathPrediction.CONV;
    AsnConverter lightsConverter = ExteriorLights.CONV;
    CONV.setComponentConverters(new AsnConverter[] { eventsConverter, compositeConverter1, compositeConverter2, lightsConverter });
  }
}
