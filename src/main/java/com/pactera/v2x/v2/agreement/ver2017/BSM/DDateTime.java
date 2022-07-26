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

public class DDateTime {
  @Null
  @Component(0)
  public Integer year;
  
  @Null
  @Component(1)
  public Integer month;
  
  @Null
  @Component(2)
  public Integer day;
  
  @Null
  @Component(3)
  public Integer hour;
  
  @Null
  @Component(4)
  public Integer minute;
  
  @Null
  @Component(5)
  public Integer second;
  
  @Null
  @Component(6)
  public Integer offset;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof DDateTime))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static DDateTime per_decode(boolean align, InputStream in) throws IOException {
    return (DDateTime)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = BSM.type(131112);
  
  public static final CompositeConverter CONV = new AnnotationCompositeConverter(DDateTime.class);
  
  static {
    AsnConverter yearConverter = DYear.CONV;
    AsnConverter monthConverter = DMonth.CONV;
    AsnConverter dayConverter = DDay.CONV;
    AsnConverter hourConverter = DHour.CONV;
    AsnConverter minuteConverter = DMinute.CONV;
    AsnConverter secondConverter = DSecond.CONV;
    AsnConverter offsetConverter = DTimeOffset.CONV;
    CONV.setComponentConverters(new AsnConverter[] { yearConverter, monthConverter, dayConverter, hourConverter, minuteConverter, secondConverter, offsetConverter });
  }
}
