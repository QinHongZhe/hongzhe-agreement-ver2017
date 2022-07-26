package com.pactera.v2x.v2.agreement.ver2017.MsgFrame;

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

/**
 * 描述了信号灯一个相位状态的完整计时状态。其中
 * start ime:表示该相位状态下一次开始(距离当前时刻)的时间,或者预测开始的时间。如
 * 果当前正值该相位状态,则该数值为0
 * minendt'ime:如果当前正值该相位状态,则此数值表示当前状态距现在的最短结束时间
 * 阳果信号灯相位并未处在该状态,则此数值表示现在距下一个该相位状态的最短时长
 * maxend Time:如果当前正值该相位状态,则此数值表示当前状态距现在的最大结束时间
 * 如果信号灯相位并未处在该状态,则此数值表示现在距下一个该相位状态的最大时长。
 * likely End Time:如果信号灯当前相位是固定时长,则该数值表示当前状态距现在的准确结束
 * 时间。如果信号灯当前相位是非固定配时(感应配时、手动控制等),则该数值表示预测
 * 的结束时间,且预测时间必须在 min Endt'ime和 maxend Time之间,可能由历史数据或一些
 * 事件触发等来进行预测。如果信号灯相位并没有处在该状态,则此数值表示下一个该相位
 * 状态的(固定或预测)时长
 * time Confidence:上述 likelv Endtime预测时间的置信度水平
 * nextstart Time:表示该相位状态从 likelyendtime时间点到第二次再出现的估计时长。与
 * starttime不同的是, start Time表示最近一次该相位状态的开始时间; nextstart Time,则表示
 * 第一次结東后,直至该相位状态第二次出现的时间间隔。通常用在一些经济驾驶模式(ECO
 * 等相关的应用中
 * texturation:表示该相位状态第二次出现时的估计持续时长。与 nextstart Time配合使用
 * 通常用在一些经济驾驶模式( ECO Drive)等相关的应用中
 */
public class TimeChangeDetails {
  @NotNull
  @Component(0)
  public Integer startTime;
  
  @Null
  @Component(1)
  public Integer minEndTime;
  
  @Null
  @Component(2)
  public Integer maxEndTime;
  
  @NotNull
  @Component(3)
  public Integer likelyEndTime;
  
  @Null
  @Component(4)
  public Integer timeConfidence;
  
  @Null
  @Component(5)
  public Integer nextStartTime;
  
  @Null
  @Component(6)
  public Integer nextDuration;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof TimeChangeDetails))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static TimeChangeDetails per_decode(boolean align, InputStream in) throws IOException {
    return (TimeChangeDetails)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = MsgFrame.type(1245315);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(TimeChangeDetails.class);
  
  static {
    AsnConverter startTimeConverter = TimeMark.CONV;
    AsnConverter minEndTimeConverter = TimeMark.CONV;
    AsnConverter maxEndTimeConverter = TimeMark.CONV;
    AsnConverter likelyEndTimeConverter = TimeMark.CONV;
    AsnConverter timeConfidenceConverter = Confidence.CONV;
    AsnConverter nextStartTimeConverter = TimeMark.CONV;
    AsnConverter nextDurationConverter = TimeMark.CONV;
    CONV.setComponentConverters(new AsnConverter[] { startTimeConverter, minEndTimeConverter, maxEndTimeConverter, likelyEndTimeConverter, timeConfidenceConverter, nextStartTimeConverter, nextDurationConverter });
  }
}
