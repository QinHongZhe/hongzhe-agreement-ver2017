package com.pactera.v2x.v2.agreement.ver2017.MapLink;

import org.asnlab.asndt.runtime.conv.AnnotationChoiceConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ChoiceConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.annotation.Alternative;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 经纬度偏差,用来描述一个坐标点的相对位置。提供了7种尺度的描述方式。
 */
public class PositionOffsetLL {
  public static final int position_LL1Chosen = 0;
  
  public static final int position_LL2Chosen = 1;
  
  public static final int position_LL3Chosen = 2;
  
  public static final int position_LL4Chosen = 3;
  
  public static final int position_LL5Chosen = 4;
  
  public static final int position_LL6Chosen = 5;
  
  public static final int position_LatLonChosen = 6;
  
  public final int choiceID;
  
  @Alternative(0)
  public final Position_LL_24B position_LL1;
  
  @Alternative(1)
  public final Position_LL_28B position_LL2;
  
  @Alternative(2)
  public final Position_LL_32B position_LL3;
  
  @Alternative(3)
  public final Position_LL_36B position_LL4;
  
  @Alternative(4)
  public final Position_LL_44B position_LL5;
  
  @Alternative(5)
  public final Position_LL_48B position_LL6;
  
  @Alternative(6)
  public final Position_LLmD_64b position_LatLon;
  
  private PositionOffsetLL(int choiceID, Position_LL_24B position_LL1, Position_LL_28B position_LL2, Position_LL_32B position_LL3, Position_LL_36B position_LL4, Position_LL_44B position_LL5, Position_LL_48B position_LL6, Position_LLmD_64b position_LatLon) {
    this.choiceID = choiceID;
    this.position_LL1 = position_LL1;
    this.position_LL2 = position_LL2;
    this.position_LL3 = position_LL3;
    this.position_LL4 = position_LL4;
    this.position_LL5 = position_LL5;
    this.position_LL6 = position_LL6;
    this.position_LatLon = position_LatLon;
  }
  
  public static PositionOffsetLL position_LL1(Position_LL_24B position_LL1) {
    return new PositionOffsetLL(0, position_LL1, null, null, null, null, null, null);
  }
  
  public static PositionOffsetLL position_LL2(Position_LL_28B position_LL2) {
    return new PositionOffsetLL(1, null, position_LL2, null, null, null, null, null);
  }
  
  public static PositionOffsetLL position_LL3(Position_LL_32B position_LL3) {
    return new PositionOffsetLL(2, null, null, position_LL3, null, null, null, null);
  }
  
  public static PositionOffsetLL position_LL4(Position_LL_36B position_LL4) {
    return new PositionOffsetLL(3, null, null, null, position_LL4, null, null, null);
  }
  
  public static PositionOffsetLL position_LL5(Position_LL_44B position_LL5) {
    return new PositionOffsetLL(4, null, null, null, null, position_LL5, null, null);
  }
  
  public static PositionOffsetLL position_LL6(Position_LL_48B position_LL6) {
    return new PositionOffsetLL(5, null, null, null, null, null, position_LL6, null);
  }
  
  public static PositionOffsetLL position_LatLon(Position_LLmD_64b position_LatLon) {
    return new PositionOffsetLL(6, null, null, null, null, null, null, position_LatLon);
  }
  
  public boolean equals(Object obj) {
    if (!(obj instanceof PositionOffsetLL))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static PositionOffsetLL per_decode(boolean align, InputStream in) throws IOException {
    return (PositionOffsetLL)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = MapLink.type(524304);
  
  public static final ChoiceConverter CONV = (ChoiceConverter)new AnnotationChoiceConverter(PositionOffsetLL.class);
  
  static {
    CompositeConverter compositeConverter1 = Position_LL_24B.CONV;
    CompositeConverter compositeConverter2 = Position_LL_28B.CONV;
    CompositeConverter compositeConverter3 = Position_LL_32B.CONV;
    CompositeConverter compositeConverter4 = Position_LL_36B.CONV;
    CompositeConverter compositeConverter5 = Position_LL_44B.CONV;
    CompositeConverter compositeConverter6 = Position_LL_48B.CONV;
    CompositeConverter compositeConverter7 = Position_LLmD_64b.CONV;
    CONV.setAlternativeConverters(new AsnConverter[] { (AsnConverter)compositeConverter1, (AsnConverter)compositeConverter2, (AsnConverter)compositeConverter3, (AsnConverter)compositeConverter4, (AsnConverter)compositeConverter5, (AsnConverter)compositeConverter6, (AsnConverter)compositeConverter7 });
  }
}
