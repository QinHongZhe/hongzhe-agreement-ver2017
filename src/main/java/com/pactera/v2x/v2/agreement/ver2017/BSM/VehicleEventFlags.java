package com.pactera.v2x.v2.agreement.ver2017.BSM;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionBitStringConverter;
import org.asnlab.asndt.runtime.type.AsnType;
import org.asnlab.asndt.runtime.value.BitString;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 定义了一系列车辆的特殊状态。如果数据某一位被置1,表示车辆处于该位对应的状态。当至
 * 少有一种对应状态被激活或者从激活状态恢复,该标志数值才应该被设置和交互.。当车辆收到一个
 * 包含车辆特殊状态的数据后,需要根据数据的内容,来选择特定的操作
 * 车辆特殊状态定义如下
 * Hazard Lights:车辆警示灯亮起
 * Stop Line Violation:车辆在到达路口前预测自己可能会来不及刹车而越过停止线
 * ABS:ABS系统被触发并超过100毫秒
 * Traction Control:牵引力控制系统被触发并超过100毫秒
 * tability Control:车身稳定控制系统被触发并超过100毫秒
 * Hazardous Materials:危险品运输车
 * Hard Braking:车辆急刹车,并且减速度大于04g,g为重力加速度典型值9.80665m
 * Lights Changed:过去2秒内,车灯状态改变
 * 过去2秒内,车辆雨刷(前窗或
 * Flat tire:车辆发现至少1个胎爆胎了
 * Disabled Vehicle:车辆故障,无法行驶
 * Air Bag Deployment:Z至少少1个安全气囊弹出
 */
public class VehicleEventFlags extends BitString {
  public static final int eventHazardLights = 0;
  
  public static final int eventStopLineViolation = 1;
  
  public static final int eventABSactivated = 2;
  
  public static final int eventTractionControlLoss = 3;
  
  public static final int eventStabilityControlactivated = 4;
  
  public static final int eventHazardousMaterials = 5;
  
  public static final int eventReserved1 = 6;
  
  public static final int eventHardBraking = 7;
  
  public static final int eventLightsChanged = 8;
  
  public static final int eventWipersChanged = 9;
  
  public static final int eventFlatTire = 10;
  
  public static final int eventDisabledVehicle = 11;
  
  public static final int eventAirBagDeployment = 12;
  
  public VehicleEventFlags(byte[] bytes, byte unusedBits) {
    super(bytes, unusedBits);
  }
  
  public VehicleEventFlags(int size) {
    super(size);
  }
  
  public VehicleEventFlags() {
    super(0);
  }
  
  public boolean getEventHazardLights() {
    return getBit(0);
  }
  
  public void setEventHazardLights() {
    setBit(0, true);
  }
  
  public void clearEventHazardLights() {
    setBit(0, false);
  }
  
  public boolean getEventStopLineViolation() {
    return getBit(1);
  }
  
  public void setEventStopLineViolation() {
    setBit(1, true);
  }
  
  public void clearEventStopLineViolation() {
    setBit(1, false);
  }
  
  public boolean getEventABSactivated() {
    return getBit(2);
  }
  
  public void setEventABSactivated() {
    setBit(2, true);
  }
  
  public void clearEventABSactivated() {
    setBit(2, false);
  }
  
  public boolean getEventTractionControlLoss() {
    return getBit(3);
  }
  
  public void setEventTractionControlLoss() {
    setBit(3, true);
  }
  
  public void clearEventTractionControlLoss() {
    setBit(3, false);
  }
  
  public boolean getEventStabilityControlactivated() {
    return getBit(4);
  }
  
  public void setEventStabilityControlactivated() {
    setBit(4, true);
  }
  
  public void clearEventStabilityControlactivated() {
    setBit(4, false);
  }
  
  public boolean getEventHazardousMaterials() {
    return getBit(5);
  }
  
  public void setEventHazardousMaterials() {
    setBit(5, true);
  }
  
  public void clearEventHazardousMaterials() {
    setBit(5, false);
  }
  
  public boolean getEventReserved1() {
    return getBit(6);
  }
  
  public void setEventReserved1() {
    setBit(6, true);
  }
  
  public void clearEventReserved1() {
    setBit(6, false);
  }
  
  public boolean getEventHardBraking() {
    return getBit(7);
  }
  
  public void setEventHardBraking() {
    setBit(7, true);
  }
  
  public void clearEventHardBraking() {
    setBit(7, false);
  }
  
  public boolean getEventLightsChanged() {
    return getBit(8);
  }
  
  public void setEventLightsChanged() {
    setBit(8, true);
  }
  
  public void clearEventLightsChanged() {
    setBit(8, false);
  }
  
  public boolean getEventWipersChanged() {
    return getBit(9);
  }
  
  public void setEventWipersChanged() {
    setBit(9, true);
  }
  
  public void clearEventWipersChanged() {
    setBit(9, false);
  }
  
  public boolean getEventFlatTire() {
    return getBit(10);
  }
  
  public void setEventFlatTire() {
    setBit(10, true);
  }
  
  public void clearEventFlatTire() {
    setBit(10, false);
  }
  
  public boolean getEventDisabledVehicle() {
    return getBit(11);
  }
  
  public void setEventDisabledVehicle() {
    setBit(11, true);
  }
  
  public void clearEventDisabledVehicle() {
    setBit(11, false);
  }
  
  public boolean getEventAirBagDeployment() {
    return getBit(12);
  }
  
  public void setEventAirBagDeployment() {
    setBit(12, true);
  }
  
  public void clearEventAirBagDeployment() {
    setBit(12, false);
  }
  
  public boolean equals(Object obj) {
    if (!(obj instanceof VehicleEventFlags))
      return false; 
    return TYPE.equals(this, obj, CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static VehicleEventFlags per_decode(boolean align, InputStream in) throws IOException {
    return (VehicleEventFlags)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = BSM.type(262181);
  
  public static final AsnConverter CONV = new ReflectionBitStringConverter(VehicleEventFlags.class);
}
