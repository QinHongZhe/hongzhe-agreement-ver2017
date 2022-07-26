package com.pactera.v2x.v2.agreement.ver2017.MsgFrame;

import org.asnlab.asndt.runtime.conv.AnnotationChoiceConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ChoiceConverter;
import org.asnlab.asndt.runtime.conv.annotation.Alternative;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class VerticalOffset {
  public static final int offset1Chosen = 0;
  
  public static final int offset2Chosen = 1;
  
  public static final int offset3Chosen = 2;
  
  public static final int offset4Chosen = 3;
  
  public static final int offset5Chosen = 4;
  
  public static final int offset6Chosen = 5;
  
  public static final int elevationChosen = 6;
  
  public final int choiceID;
  
  @Alternative(0)
  public final Integer offset1;
  
  @Alternative(1)
  public final Integer offset2;
  
  @Alternative(2)
  public final Integer offset3;
  
  @Alternative(3)
  public final Integer offset4;
  
  @Alternative(4)
  public final Integer offset5;
  
  @Alternative(5)
  public final Integer offset6;
  
  @Alternative(6)
  public final Integer elevation;
  
  private VerticalOffset(int choiceID, Integer offset1, Integer offset2, Integer offset3, Integer offset4, Integer offset5, Integer offset6, Integer elevation) {
    this.choiceID = choiceID;
    this.offset1 = offset1;
    this.offset2 = offset2;
    this.offset3 = offset3;
    this.offset4 = offset4;
    this.offset5 = offset5;
    this.offset6 = offset6;
    this.elevation = elevation;
  }
  
  public static VerticalOffset offset1(Integer offset1) {
    return new VerticalOffset(0, offset1, null, null, null, null, null, null);
  }
  
  public static VerticalOffset offset2(Integer offset2) {
    return new VerticalOffset(1, null, offset2, null, null, null, null, null);
  }
  
  public static VerticalOffset offset3(Integer offset3) {
    return new VerticalOffset(2, null, null, offset3, null, null, null, null);
  }
  
  public static VerticalOffset offset4(Integer offset4) {
    return new VerticalOffset(3, null, null, null, offset4, null, null, null);
  }
  
  public static VerticalOffset offset5(Integer offset5) {
    return new VerticalOffset(4, null, null, null, null, offset5, null, null);
  }
  
  public static VerticalOffset offset6(Integer offset6) {
    return new VerticalOffset(5, null, null, null, null, null, offset6, null);
  }
  
  public static VerticalOffset elevation(Integer elevation) {
    return new VerticalOffset(6, null, null, null, null, null, null, elevation);
  }
  
  public boolean equals(Object obj) {
    if (!(obj instanceof VerticalOffset))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static VerticalOffset per_decode(boolean align, InputStream in) throws IOException {
    return (VerticalOffset)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = MsgFrame.type(786499);
  
  public static final ChoiceConverter CONV = (ChoiceConverter)new AnnotationChoiceConverter(VerticalOffset.class);
  
  static {
    AsnConverter offset1Converter = VertOffset_B07.CONV;
    AsnConverter offset2Converter = VertOffset_B08.CONV;
    AsnConverter offset3Converter = VertOffset_B09.CONV;
    AsnConverter offset4Converter = VertOffset_B10.CONV;
    AsnConverter offset5Converter = VertOffset_B11.CONV;
    AsnConverter offset6Converter = VertOffset_B12.CONV;
    AsnConverter elevationConverter = Elevation.CONV;
    CONV.setAlternativeConverters(new AsnConverter[] { offset1Converter, offset2Converter, offset3Converter, offset4Converter, offset5Converter, offset6Converter, elevationConverter });
  }
}
