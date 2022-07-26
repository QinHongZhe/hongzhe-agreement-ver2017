package com.pactera.v2x.v2.agreement.ver2017.RSM;

import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.IntegerConverter;
import org.asnlab.asndt.runtime.conv.OctetStringConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 定义交通参与者的基本安全信息。对应BSM消息,该参与者信息由RSU探测得到。
 */
public class ParticipantData {
  @NotNull
  @Component(0)
  public ParticipantType ptcType;
  
  @NotNull
  @Min(0L)
  @Max(65535L)
  @Component(1)
  public Integer ptcId;
  
  @NotNull
  @Component(2)
  public SourceType source;
  
  @Null
  @Size(min = 8, max = 8)
  @Component(3)
  public byte[] id;
  
  @Null
  @Size(min = 4, max = 16)
  @Component(4)
  public byte[] plateNo;
  
  @NotNull
  @Component(5)
  public Integer secMark;
  
  @NotNull
  @Component(6)
  public PositionOffsetLLV pos;
  
  @NotNull
  @Component(7)
  public PositionConfidenceSet accuracy;
  
  @Null
  @Component(8)
  public TransmissionState transmission;
  
  @NotNull
  @Component(9)
  public Integer speed;
  
  @NotNull
  @Component(10)
  public Integer heading;
  
  @Null
  @Component(11)
  public Integer angle;
  
  @Null
  @Component(12)
  public MotionConfidenceSet motionCfd;
  
  @Null
  @Component(13)
  public AccelerationSet4Way accelSet;
  
  @NotNull
  @Component(14)
  public VehicleSize size;
  
  @Null
  @Component(15)
  public VehicleClassification vehicleClass;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof ParticipantData))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static ParticipantData per_decode(boolean align, InputStream in) throws IOException {
    return (ParticipantData)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = RSM.type(65586);
  
  public static final CompositeConverter CONV = new AnnotationCompositeConverter(ParticipantData.class);
  
  static {
    AsnConverter ptcTypeConverter = ParticipantType.CONV;
    IntegerConverter integerConverter = IntegerConverter.INSTANCE;
    AsnConverter sourceConverter = SourceType.CONV;
    OctetStringConverter octetStringConverter1 = OctetStringConverter.INSTANCE;
    OctetStringConverter octetStringConverter2 = OctetStringConverter.INSTANCE;
    AsnConverter secMarkConverter = DSecond.CONV;
    CompositeConverter compositeConverter1 = PositionOffsetLLV.CONV;
    CompositeConverter compositeConverter2 = PositionConfidenceSet.CONV;
    AsnConverter transmissionConverter = TransmissionState.CONV;
    AsnConverter speedConverter = Speed.CONV;
    AsnConverter headingConverter = Heading.CONV;
    AsnConverter angleConverter = SteeringWheelAngle.CONV;
    CompositeConverter compositeConverter3 = MotionConfidenceSet.CONV;
    CompositeConverter compositeConverter4 = AccelerationSet4Way.CONV;
    CompositeConverter compositeConverter5 = VehicleSize.CONV;
    CompositeConverter compositeConverter6 = VehicleClassification.CONV;
    CONV.setComponentConverters(new AsnConverter[] {
          ptcTypeConverter, integerConverter, sourceConverter, octetStringConverter1, octetStringConverter2, secMarkConverter, compositeConverter1, compositeConverter2, transmissionConverter, speedConverter,
          headingConverter, angleConverter, compositeConverter3, compositeConverter4, compositeConverter5, compositeConverter6});
  }
}
