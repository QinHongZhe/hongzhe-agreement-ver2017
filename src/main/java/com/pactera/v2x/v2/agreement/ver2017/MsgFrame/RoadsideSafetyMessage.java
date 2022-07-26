package com.pactera.v2x.v2.agreement.ver2017.MsgFrame;

import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.OctetStringConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

public class RoadsideSafetyMessage {
  @NotNull
  @Component(0)
  public Integer msgCnt;
  
  @NotNull
  @Size(min = 8, max = 8)
  @Component(1)
  public byte[] id;
  
  @NotNull
  @Component(2)
  public Position3D refPos;
  
  @NotNull
  @Component(3)
  public Vector<ParticipantData> participants;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof RoadsideSafetyMessage))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static RoadsideSafetyMessage per_decode(boolean align, InputStream in) throws IOException {
    return (RoadsideSafetyMessage)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = MsgFrame.type(1310837);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(RoadsideSafetyMessage.class);
  
  static {
    AsnConverter msgCntConverter = MsgCount.CONV;
    OctetStringConverter octetStringConverter = OctetStringConverter.INSTANCE;
    CompositeConverter compositeConverter = Position3D.CONV;
    AsnConverter participantsConverter = ParticipantList.CONV;
    CONV.setComponentConverters(new AsnConverter[] { msgCntConverter, (AsnConverter)octetStringConverter, (AsnConverter)compositeConverter, participantsConverter });
  }
}
