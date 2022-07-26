package com.pactera.v2x.v2.agreement.ver2017.MapLane;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionBitStringConverter;
import org.asnlab.asndt.runtime.type.AsnType;
import org.asnlab.asndt.runtime.value.BitString;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 停车车道的属性定义。指示车道允许停车的种类和停靠方式。
 */
public class LaneAttributes_Parking extends BitString {
  public static final int parkingRevocableLane = 0;
  
  public static final int parallelParkingInUse = 1;
  
  public static final int headInParkingInUse = 2;
  
  public static final int doNotParkZone = 3;
  
  public static final int parkingForBusUse = 4;
  
  public static final int parkingForTaxiUse = 5;
  
  public static final int noPublicParkingUse = 6;
  
  public LaneAttributes_Parking(byte[] bytes, byte unusedBits) {
    super(bytes, unusedBits);
  }
  
  public LaneAttributes_Parking(int size) {
    super(size);
  }
  
  public LaneAttributes_Parking() {
    super(0);
  }
  
  public boolean getParkingRevocableLane() {
    return getBit(0);
  }
  
  public void setParkingRevocableLane() {
    setBit(0, true);
  }
  
  public void clearParkingRevocableLane() {
    setBit(0, false);
  }
  
  public boolean getParallelParkingInUse() {
    return getBit(1);
  }
  
  public void setParallelParkingInUse() {
    setBit(1, true);
  }
  
  public void clearParallelParkingInUse() {
    setBit(1, false);
  }
  
  public boolean getHeadInParkingInUse() {
    return getBit(2);
  }
  
  public void setHeadInParkingInUse() {
    setBit(2, true);
  }
  
  public void clearHeadInParkingInUse() {
    setBit(2, false);
  }
  
  public boolean getDoNotParkZone() {
    return getBit(3);
  }
  
  public void setDoNotParkZone() {
    setBit(3, true);
  }
  
  public void clearDoNotParkZone() {
    setBit(3, false);
  }
  
  public boolean getParkingForBusUse() {
    return getBit(4);
  }
  
  public void setParkingForBusUse() {
    setBit(4, true);
  }
  
  public void clearParkingForBusUse() {
    setBit(4, false);
  }
  
  public boolean getParkingForTaxiUse() {
    return getBit(5);
  }
  
  public void setParkingForTaxiUse() {
    setBit(5, true);
  }
  
  public void clearParkingForTaxiUse() {
    setBit(5, false);
  }
  
  public boolean getNoPublicParkingUse() {
    return getBit(6);
  }
  
  public void setNoPublicParkingUse() {
    setBit(6, true);
  }
  
  public void clearNoPublicParkingUse() {
    setBit(6, false);
  }
  
  public boolean equals(Object obj) {
    if (!(obj instanceof LaneAttributes_Parking))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static LaneAttributes_Parking per_decode(boolean align, InputStream in) throws IOException {
    return (LaneAttributes_Parking)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = MapLane.type(65546);
  
  public static final AsnConverter CONV = (AsnConverter)new ReflectionBitStringConverter(LaneAttributes_Parking.class);
}
