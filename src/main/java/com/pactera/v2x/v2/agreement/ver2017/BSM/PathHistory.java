package com.pactera.v2x.v2.agreement.ver2017.BSM;

import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

/**
 * 定义车辆历史轨迹
 * 利用一个参考轨迹点信息,以及一系列基于该参考信息的历史轨迹点,给出车辆一段完整的历
 * 史轨迹。车辆历史轨迹能够真实地反映其在当时的行驶状态,且从侧面反映当时其所在的道路和交
 * 数据单元中的参考轨迹点信息在时间上比所有轨迹点都要靠后(时间较晚)
 */
public class PathHistory {
  @Null
  @Component(0)
  public FullPositionVector initialPosition;
  
  @Null
  @Component(1)
  public GNSSstatus currGNSSstatus;
  
  @NotNull
  @Component(2)
  public Vector<PathHistoryPoint> crumbData;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof PathHistory))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static PathHistory per_decode(boolean align, InputStream in) throws IOException {
    return (PathHistory)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = BSM.type(655398);
  
  public static final CompositeConverter CONV = new AnnotationCompositeConverter(PathHistory.class);
  
  static {
    CompositeConverter compositeConverter = FullPositionVector.CONV;
    AsnConverter currGNSSstatusConverter = GNSSstatus.CONV;
    AsnConverter crumbDataConverter = PathHistoryPointList.CONV;
    CONV.setComponentConverters(new AsnConverter[] {compositeConverter, currGNSSstatusConverter, crumbDataConverter });
  }
}
