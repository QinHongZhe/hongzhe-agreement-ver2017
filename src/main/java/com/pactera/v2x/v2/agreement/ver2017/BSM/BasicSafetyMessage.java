package com.pactera.v2x.v2.agreement.ver2017.BSM;

import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.OctetStringConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BasicSafetyMessage {
  @NotNull
  @Component(0)
  public Integer msgCnt;
  
  @NotNull
  @Size(min = 8, max = 8)
  @Component(1)
  public byte[] id;
  
  @Null
  @Size(min = 4, max = 16)
  @Component(2)
  public byte[] plateNo;
  
  @NotNull
  @Component(3)
  public Integer secMark;
  
  @NotNull
  @Component(4)
  public Position3D pos;
  
  @NotNull
  @Component(5)
  public PositionConfidenceSet accuracy;
  
  @NotNull
  @Component(6)
  public TransmissionState transmission;
  
  @NotNull
  @Component(7)
  public Integer speed;
  
  @NotNull
  @Component(8)
  public Integer heading;
  
  @Null
  @Component(9)
  public Integer angle;
  
  @Null
  @Component(10)
  public MotionConfidenceSet motionCfd;
  
  @NotNull
  @Component(11)
  public AccelerationSet4Way accelSet;
  
  @NotNull
  @Component(12)
  public BrakeSystemStatus brakes;
  
  @NotNull
  @Component(13)
  public VehicleSize size;
  
  @NotNull
  @Component(14)
  public VehicleClassification vehicleClass;
  
  @Null
  @Component(15)
  public VehicleSafetyExtensions safetyExt;
  
  @Null
  @Size(min = 4, max = 4)
  @Component(16)
  public byte[] token;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof BasicSafetyMessage))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static BasicSafetyMessage per_decode(boolean align, InputStream in) throws IOException {
    return (BasicSafetyMessage)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = BSM.type(786511);
  
  public static final CompositeConverter CONV = new AnnotationCompositeConverter(BasicSafetyMessage.class);
  
  static {
    AsnConverter msgCntConverter = MsgCount.CONV;
    OctetStringConverter octetStringConverter1 = OctetStringConverter.INSTANCE;
    OctetStringConverter octetStringConverter2 = OctetStringConverter.INSTANCE;
    AsnConverter secMarkConverter = DSecond.CONV;
    CompositeConverter compositeConverter1 = Position3D.CONV;
    CompositeConverter compositeConverter2 = PositionConfidenceSet.CONV;
    AsnConverter transmissionConverter = TransmissionState.CONV;
    AsnConverter speedConverter = Speed.CONV;
    AsnConverter headingConverter = Heading.CONV;
    AsnConverter angleConverter = SteeringWheelAngle.CONV;
    CompositeConverter compositeConverter3 = MotionConfidenceSet.CONV;
    CompositeConverter compositeConverter4 = AccelerationSet4Way.CONV;
    CompositeConverter compositeConverter5 = BrakeSystemStatus.CONV;
    CompositeConverter compositeConverter6 = VehicleSize.CONV;
    CompositeConverter compositeConverter7 = VehicleClassification.CONV;
    CompositeConverter compositeConverter8 = VehicleSafetyExtensions.CONV;
    OctetStringConverter octetStringConverter3 = OctetStringConverter.INSTANCE;
    CONV.setComponentConverters(new AsnConverter[] {
          msgCntConverter, octetStringConverter1, octetStringConverter2, secMarkConverter, compositeConverter1, compositeConverter2, transmissionConverter, speedConverter, headingConverter, angleConverter,
            compositeConverter3, compositeConverter4, compositeConverter5, compositeConverter6, compositeConverter7, compositeConverter8, octetStringConverter3});
  }
}
