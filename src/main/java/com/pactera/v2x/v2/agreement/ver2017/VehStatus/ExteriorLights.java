package com.pactera.v2x.v2.agreement.ver2017.VehStatus;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionBitStringConverter;
import org.asnlab.asndt.runtime.type.AsnType;
import org.asnlab.asndt.runtime.value.BitString;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 定义车身周围的车灯状态。
 */
public class ExteriorLights extends BitString {
  public static final int lowBeamHeadlightsOn = 0;
  
  public static final int highBeamHeadlightsOn = 1;
  
  public static final int leftTurnSignalOn = 2;
  
  public static final int rightTurnSignalOn = 3;
  
  public static final int hazardSignalOn = 4;
  
  public static final int automaticLightControlOn = 5;
  
  public static final int daytimeRunningLightsOn = 6;
  
  public static final int fogLightOn = 7;
  
  public static final int parkingLightsOn = 8;
  
  public ExteriorLights(byte[] bytes, byte unusedBits) {
    super(bytes, unusedBits);
  }
  
  public ExteriorLights(int size) {
    super(size);
  }
  
  public ExteriorLights() {
    super(0);
  }
  
  public boolean getLowBeamHeadlightsOn() {
    return getBit(0);
  }
  
  public void setLowBeamHeadlightsOn() {
    setBit(0, true);
  }
  
  public void clearLowBeamHeadlightsOn() {
    setBit(0, false);
  }
  
  public boolean getHighBeamHeadlightsOn() {
    return getBit(1);
  }
  
  public void setHighBeamHeadlightsOn() {
    setBit(1, true);
  }
  
  public void clearHighBeamHeadlightsOn() {
    setBit(1, false);
  }
  
  public boolean getLeftTurnSignalOn() {
    return getBit(2);
  }
  
  public void setLeftTurnSignalOn() {
    setBit(2, true);
  }
  
  public void clearLeftTurnSignalOn() {
    setBit(2, false);
  }
  
  public boolean getRightTurnSignalOn() {
    return getBit(3);
  }
  
  public void setRightTurnSignalOn() {
    setBit(3, true);
  }
  
  public void clearRightTurnSignalOn() {
    setBit(3, false);
  }
  
  public boolean getHazardSignalOn() {
    return getBit(4);
  }
  
  public void setHazardSignalOn() {
    setBit(4, true);
  }
  
  public void clearHazardSignalOn() {
    setBit(4, false);
  }
  
  public boolean getAutomaticLightControlOn() {
    return getBit(5);
  }
  
  public void setAutomaticLightControlOn() {
    setBit(5, true);
  }
  
  public void clearAutomaticLightControlOn() {
    setBit(5, false);
  }
  
  public boolean getDaytimeRunningLightsOn() {
    return getBit(6);
  }
  
  public void setDaytimeRunningLightsOn() {
    setBit(6, true);
  }
  
  public void clearDaytimeRunningLightsOn() {
    setBit(6, false);
  }
  
  public boolean getFogLightOn() {
    return getBit(7);
  }
  
  public void setFogLightOn() {
    setBit(7, true);
  }
  
  public void clearFogLightOn() {
    setBit(7, false);
  }
  
  public boolean getParkingLightsOn() {
    return getBit(8);
  }
  
  public void setParkingLightsOn() {
    setBit(8, true);
  }
  
  public void clearParkingLightsOn() {
    setBit(8, false);
  }
  
  public boolean equals(Object obj) {
    if (!(obj instanceof ExteriorLights))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static ExteriorLights per_decode(boolean align, InputStream in) throws IOException {
    return (ExteriorLights)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = VehStatus.type(65539);
  
  public static final AsnConverter CONV = (AsnConverter)new ReflectionBitStringConverter(ExteriorLights.class);
}
