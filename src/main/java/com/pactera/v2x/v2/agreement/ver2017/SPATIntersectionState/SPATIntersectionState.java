package com.pactera.v2x.v2.agreement.ver2017.SPATIntersectionState;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.type.AsnModule;
import org.asnlab.asndt.runtime.type.AsnType;

import java.util.Vector;

public class SPATIntersectionState extends AsnModule {
  public static final SPATIntersectionState instance = new SPATIntersectionState();
  
  private SPATIntersectionState() {
    super(SPATIntersectionState.class);
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
