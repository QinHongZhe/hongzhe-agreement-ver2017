package com.pactera.v2x.v2.agreement.ver2017.SignalPhaseAndTiming;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.type.AsnModule;
import org.asnlab.asndt.runtime.type.AsnType;

import java.util.Vector;

public class SignalPhaseAndTiming extends AsnModule {
  public static final SignalPhaseAndTiming instance = new SignalPhaseAndTiming();
  
  private SignalPhaseAndTiming() {
    super(SignalPhaseAndTiming.class);
  }
  
  public static AsnType type(int id) {
    return instance.getType(id);
  }
  
  public static Object value(int valueId, AsnConverter converter) {
    return instance.getValue(valueId, converter);
  }
  
  public static Object object(int objectId, AsnConverter converter) {
    return instance.getObject(objectId, converter);
  }
  
  public static Vector objectSet(int objectSetId, AsnConverter converter) {
    return instance.getObjectSet(objectSetId, converter);
  }
}
