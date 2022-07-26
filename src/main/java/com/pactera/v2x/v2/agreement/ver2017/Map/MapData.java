package com.pactera.v2x.v2.agreement.ver2017.Map;

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

public class MapData {
  @NotNull
  @Component(0)
  public Integer msgCnt;
  
  @Null
  @Component(1)
  public Integer timeStamp;
  
  @NotNull
  @Component(2)
  public Vector<Node> nodes;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof MapData))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static MapData per_decode(boolean align, InputStream in) throws IOException {
    return (MapData)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = Map.type(786497);
  
  public static final CompositeConverter CONV = new AnnotationCompositeConverter(MapData.class);
  
  static {
    AsnConverter msgCntConverter = MsgCount.CONV;
    AsnConverter timeStampConverter = MinuteOfTheYear.CONV;
    AsnConverter nodesConverter = NodeList.CONV;
    CONV.setComponentConverters(new AsnConverter[] { msgCntConverter, timeStampConverter, nodesConverter });
  }
}
