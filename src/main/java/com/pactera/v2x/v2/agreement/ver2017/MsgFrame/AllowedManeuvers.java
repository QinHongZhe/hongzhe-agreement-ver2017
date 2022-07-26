package com.pactera.v2x.v2.agreement.ver2017.MsgFrame;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionBitStringConverter;
import org.asnlab.asndt.runtime.type.AsnType;
import org.asnlab.asndt.runtime.value.BitString;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 定义一个(机动车)车道的允许转向行为。
 */
public class AllowedManeuvers extends BitString {
  public static final int maneuverStraightAllowed = 0;
  
  public static final int maneuverLeftAllowed = 1;
  
  public static final int maneuverRightAllowed = 2;
  
  public static final int maneuverUTurnAllowed = 3;
  
  public static final int maneuverLeftTurnOnRedAllowed = 4;
  
  public static final int maneuverRightTurnOnRedAllowed = 5;
  
  public static final int maneuverLaneChangeAllowed = 6;
  
  public static final int maneuverNoStoppingAllowed = 7;
  
  public static final int yieldAllwaysRequired = 8;
  
  public static final int goWithHalt = 9;
  
  public static final int caution = 10;
  
  public static final int reserved1 = 11;
  
  public AllowedManeuvers(byte[] bytes, byte unusedBits) {
    super(bytes, unusedBits);
  }
  
  public AllowedManeuvers(int size) {
    super(size);
  }
  
  public AllowedManeuvers() {
    super(0);
  }
  
  public boolean getManeuverStraightAllowed() {
    return getBit(0);
  }
  
  public void setManeuverStraightAllowed() {
    setBit(0, true);
  }
  
  public void clearManeuverStraightAllowed() {
    setBit(0, false);
  }
  
  public boolean getManeuverLeftAllowed() {
    return getBit(1);
  }
  
  public void setManeuverLeftAllowed() {
    setBit(1, true);
  }
  
  public void clearManeuverLeftAllowed() {
    setBit(1, false);
  }
  
  public boolean getManeuverRightAllowed() {
    return getBit(2);
  }
  
  public void setManeuverRightAllowed() {
    setBit(2, true);
  }
  
  public void clearManeuverRightAllowed() {
    setBit(2, false);
  }
  
  public boolean getManeuverUTurnAllowed() {
    return getBit(3);
  }
  
  public void setManeuverUTurnAllowed() {
    setBit(3, true);
  }
  
  public void clearManeuverUTurnAllowed() {
    setBit(3, false);
  }
  
  public boolean getManeuverLeftTurnOnRedAllowed() {
    return getBit(4);
  }
  
  public void setManeuverLeftTurnOnRedAllowed() {
    setBit(4, true);
  }
  
  public void clearManeuverLeftTurnOnRedAllowed() {
    setBit(4, false);
  }
  
  public boolean getManeuverRightTurnOnRedAllowed() {
    return getBit(5);
  }
  
  public void setManeuverRightTurnOnRedAllowed() {
    setBit(5, true);
  }
  
  public void clearManeuverRightTurnOnRedAllowed() {
    setBit(5, false);
  }
  
  public boolean getManeuverLaneChangeAllowed() {
    return getBit(6);
  }
  
  public void setManeuverLaneChangeAllowed() {
    setBit(6, true);
  }
  
  public void clearManeuverLaneChangeAllowed() {
    setBit(6, false);
  }
  
  public boolean getManeuverNoStoppingAllowed() {
    return getBit(7);
  }
  
  public void setManeuverNoStoppingAllowed() {
    setBit(7, true);
  }
  
  public void clearManeuverNoStoppingAllowed() {
    setBit(7, false);
  }
  
  public boolean getYieldAllwaysRequired() {
    return getBit(8);
  }
  
  public void setYieldAllwaysRequired() {
    setBit(8, true);
  }
  
  public void clearYieldAllwaysRequired() {
    setBit(8, false);
  }
  
  public boolean getGoWithHalt() {
    return getBit(9);
  }
  
  public void setGoWithHalt() {
    setBit(9, true);
  }
  
  public void clearGoWithHalt() {
    setBit(9, false);
  }
  
  public boolean getCaution() {
    return getBit(10);
  }
  
  public void setCaution() {
    setBit(10, true);
  }
  
  public void clearCaution() {
    setBit(10, false);
  }
  
  public boolean getReserved1() {
    return getBit(11);
  }
  
  public void setReserved1() {
    setBit(11, true);
  }
  
  public void clearReserved1() {
    setBit(11, false);
  }
  
  public boolean equals(Object obj) {
    if (!(obj instanceof AllowedManeuvers))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static AllowedManeuvers per_decode(boolean align, InputStream in) throws IOException {
    return (AllowedManeuvers)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = MsgFrame.type(1114225);
  
  public static final AsnConverter CONV = (AsnConverter)new ReflectionBitStringConverter(AllowedManeuvers.class);
}
