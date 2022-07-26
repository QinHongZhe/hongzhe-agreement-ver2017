package com.pactera.v2x.v2.agreement.ver2017.MsgFrame;

import org.asnlab.asndt.runtime.conv.AnnotationChoiceConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ChoiceConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.annotation.Alternative;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MessageFrame {
  public static final int bsmFrameChosen = 0;
  
  public static final int mapFrameChosen = 1;
  
  public static final int rsmFrameChosen = 2;
  
  public static final int spatFrameChosen = 3;
  
  public static final int rsiFrameChosen = 4;
  
  public final int choiceID;
  
  @Alternative(0)
  public final BasicSafetyMessage bsmFrame;
  
  @Alternative(1)
  public final MapData mapFrame;
  
  @Alternative(2)
  public final RoadsideSafetyMessage rsmFrame;
  
  @Alternative(3)
  public final SPAT spatFrame;
  
  @Alternative(4)
  public final RoadSideInformation rsiFrame;
  
  private MessageFrame(int choiceID, BasicSafetyMessage bsmFrame, MapData mapFrame, RoadsideSafetyMessage rsmFrame, SPAT spatFrame, RoadSideInformation rsiFrame) {
    this.choiceID = choiceID;
    this.bsmFrame = bsmFrame;
    this.mapFrame = mapFrame;
    this.rsmFrame = rsmFrame;
    this.spatFrame = spatFrame;
    this.rsiFrame = rsiFrame;
  }
  
  public static MessageFrame bsmFrame(BasicSafetyMessage bsmFrame) {
    return new MessageFrame(0, bsmFrame, null, null, null, null);
  }
  
  public static MessageFrame mapFrame(MapData mapFrame) {
    return new MessageFrame(1, null, mapFrame, null, null, null);
  }
  
  public static MessageFrame rsmFrame(RoadsideSafetyMessage rsmFrame) {
    return new MessageFrame(2, null, null, rsmFrame, null, null);
  }
  
  public static MessageFrame spatFrame(SPAT spatFrame) {
    return new MessageFrame(3, null, null, null, spatFrame, null);
  }
  
  public static MessageFrame rsiFrame(RoadSideInformation rsiFrame) {
    return new MessageFrame(4, null, null, null, null, rsiFrame);
  }
  
  public boolean equals(Object obj) {
    if (!(obj instanceof MessageFrame))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static MessageFrame per_decode(boolean align, InputStream in) throws IOException {
    return (MessageFrame)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = MsgFrame.type(131210);
  
  public static final ChoiceConverter CONV = (ChoiceConverter)new AnnotationChoiceConverter(MessageFrame.class);
  
  static {
    CompositeConverter compositeConverter1 = BasicSafetyMessage.CONV;
    CompositeConverter compositeConverter2 = MapData.CONV;
    CompositeConverter compositeConverter3 = RoadsideSafetyMessage.CONV;
    CompositeConverter compositeConverter4 = SPAT.CONV;
    CompositeConverter compositeConverter5 = RoadSideInformation.CONV;
    CONV.setAlternativeConverters(new AsnConverter[] { (AsnConverter)compositeConverter1, (AsnConverter)compositeConverter2, (AsnConverter)compositeConverter3, (AsnConverter)compositeConverter4, (AsnConverter)compositeConverter5 });
  }
}
