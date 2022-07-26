package com.pactera.v2x.v2.agreement.ver2017.MapNode;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionBitStringConverter;
import org.asnlab.asndt.runtime.type.AsnType;
import org.asnlab.asndt.runtime.value.BitString;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 定义车道被共享的情况。在已有的车道属性定义基础上,该数据表示此车道还会有其他的交通
 * 参与者者出现,并可能拥有相同的路权。
 * 数据每一个比特位,如果是“1”,则表示对应的车道共享属性生效
 */
public class LaneSharing extends BitString {
  public static final int overlappingLaneDescriptionProvided = 0;
  
  public static final int multipleLanesTreatedAsOneLane = 1;
  
  public static final int otherNonMotorizedTrafficTypes = 2;
  
  public static final int individualMotorizedVehicleTraffic = 3;
  
  public static final int busVehicleTraffic = 4;
  
  public static final int taxiVehicleTraffic = 5;
  
  public static final int pedestriansTraffic = 6;
  
  public static final int cyclistVehicleTraffic = 7;
  
  public static final int trackedVehicleTraffic = 8;
  
  public static final int pedestrianTraffic = 9;
  
  public LaneSharing(byte[] bytes, byte unusedBits) {
    super(bytes, unusedBits);
  }
  
  public LaneSharing(int size) {
    super(size);
  }
  
  public LaneSharing() {
    super(0);
  }
  
  public boolean getOverlappingLaneDescriptionProvided() {
    return getBit(0);
  }
  
  public void setOverlappingLaneDescriptionProvided() {
    setBit(0, true);
  }
  
  public void clearOverlappingLaneDescriptionProvided() {
    setBit(0, false);
  }
  
  public boolean getMultipleLanesTreatedAsOneLane() {
    return getBit(1);
  }
  
  public void setMultipleLanesTreatedAsOneLane() {
    setBit(1, true);
  }
  
  public void clearMultipleLanesTreatedAsOneLane() {
    setBit(1, false);
  }
  
  public boolean getOtherNonMotorizedTrafficTypes() {
    return getBit(2);
  }
  
  public void setOtherNonMotorizedTrafficTypes() {
    setBit(2, true);
  }
  
  public void clearOtherNonMotorizedTrafficTypes() {
    setBit(2, false);
  }
  
  public boolean getIndividualMotorizedVehicleTraffic() {
    return getBit(3);
  }
  
  public void setIndividualMotorizedVehicleTraffic() {
    setBit(3, true);
  }
  
  public void clearIndividualMotorizedVehicleTraffic() {
    setBit(3, false);
  }
  
  public boolean getBusVehicleTraffic() {
    return getBit(4);
  }
  
  public void setBusVehicleTraffic() {
    setBit(4, true);
  }
  
  public void clearBusVehicleTraffic() {
    setBit(4, false);
  }
  
  public boolean getTaxiVehicleTraffic() {
    return getBit(5);
  }
  
  public void setTaxiVehicleTraffic() {
    setBit(5, true);
  }
  
  public void clearTaxiVehicleTraffic() {
    setBit(5, false);
  }
  
  public boolean getPedestriansTraffic() {
    return getBit(6);
  }
  
  public void setPedestriansTraffic() {
    setBit(6, true);
  }
  
  public void clearPedestriansTraffic() {
    setBit(6, false);
  }
  
  public boolean getCyclistVehicleTraffic() {
    return getBit(7);
  }
  
  public void setCyclistVehicleTraffic() {
    setBit(7, true);
  }
  
  public void clearCyclistVehicleTraffic() {
    setBit(7, false);
  }
  
  public boolean getTrackedVehicleTraffic() {
    return getBit(8);
  }
  
  public void setTrackedVehicleTraffic() {
    setBit(8, true);
  }
  
  public void clearTrackedVehicleTraffic() {
    setBit(8, false);
  }
  
  public boolean getPedestrianTraffic() {
    return getBit(9);
  }
  
  public void setPedestrianTraffic() {
    setBit(9, true);
  }
  
  public void clearPedestrianTraffic() {
    setBit(9, false);
  }
  
  public boolean equals(Object obj) {
    if (!(obj instanceof LaneSharing))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static LaneSharing per_decode(boolean align, InputStream in) throws IOException {
    return (LaneSharing)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = MapNode.type(393263);
  
  public static final AsnConverter CONV = (AsnConverter)new ReflectionBitStringConverter(LaneSharing.class);
}
