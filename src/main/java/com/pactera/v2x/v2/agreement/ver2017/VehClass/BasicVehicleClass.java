package com.pactera.v2x.v2.agreement.ver2017.VehClass;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.IntegerConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 定义车辆基本类型。
 */
public class BasicVehicleClass {
  public static void per_encode(Integer object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Integer per_decode(boolean align, InputStream in) throws IOException {
    return (Integer)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = VehClass.type(65537);
  
  public static final AsnConverter CONV = (AsnConverter) IntegerConverter.INSTANCE;
  
  public static final Integer unknownVehicleClass = (Integer)VehClass.value(65538, CONV);
  
  public static final Integer specialVehicleClass = (Integer)VehClass.value(65539, CONV);
  
  public static final Integer passenger_Vehicle_TypeUnknown = (Integer)VehClass.value(65540, CONV);
  
  public static final Integer passenger_Vehicle_TypeOther = (Integer)VehClass.value(65541, CONV);
  
  public static final Integer lightTruck_Vehicle_TypeUnknown = (Integer)VehClass.value(65542, CONV);
  
  public static final Integer lightTruck_Vehicle_TypeOther = (Integer)VehClass.value(65543, CONV);
  
  public static final Integer truck_Vehicle_TypeUnknown = (Integer)VehClass.value(65544, CONV);
  
  public static final Integer truck_Vehicle_TypeOther = (Integer)VehClass.value(65545, CONV);
  
  public static final Integer truck_axleCnt2 = (Integer)VehClass.value(65546, CONV);
  
  public static final Integer truck_axleCnt3 = (Integer)VehClass.value(65547, CONV);
  
  public static final Integer truck_axleCnt4 = (Integer)VehClass.value(65548, CONV);
  
  public static final Integer truck_axleCnt4Trailer = (Integer)VehClass.value(65549, CONV);
  
  public static final Integer truck_axleCnt5Trailer = (Integer)VehClass.value(65550, CONV);
  
  public static final Integer truck_axleCnt6Trailer = (Integer)VehClass.value(65551, CONV);
  
  public static final Integer truck_axleCnt5MultiTrailer = (Integer)VehClass.value(65552, CONV);
  
  public static final Integer truck_axleCnt6MultiTrailer = (Integer)VehClass.value(65553, CONV);
  
  public static final Integer truck_axleCnt7MultiTrailer = (Integer)VehClass.value(65554, CONV);
  
  public static final Integer motorcycle_TypeUnknown = (Integer)VehClass.value(65555, CONV);
  
  public static final Integer motorcycle_TypeOther = (Integer)VehClass.value(65556, CONV);
  
  public static final Integer motorcycle_Cruiser_Standard = (Integer)VehClass.value(65557, CONV);
  
  public static final Integer motorcycle_SportUnclad = (Integer)VehClass.value(65558, CONV);
  
  public static final Integer motorcycle_SportTouring = (Integer)VehClass.value(65559, CONV);
  
  public static final Integer motorcycle_SuperSport = (Integer)VehClass.value(65560, CONV);
  
  public static final Integer motorcycle_Touring = (Integer)VehClass.value(65561, CONV);
  
  public static final Integer motorcycle_Trike = (Integer)VehClass.value(65562, CONV);
  
  public static final Integer motorcycle_wPassengers = (Integer)VehClass.value(65563, CONV);
  
  public static final Integer transit_TypeUnknown = (Integer)VehClass.value(65564, CONV);
  
  public static final Integer transit_TypeOther = (Integer)VehClass.value(65565, CONV);
  
  public static final Integer transit_BRT = (Integer)VehClass.value(65566, CONV);
  
  public static final Integer transit_ExpressBus = (Integer)VehClass.value(65567, CONV);
  
  public static final Integer transit_LocalBus = (Integer)VehClass.value(65568, CONV);
  
  public static final Integer transit_SchoolBus = (Integer)VehClass.value(65569, CONV);
  
  public static final Integer transit_FixedGuideway = (Integer)VehClass.value(65570, CONV);
  
  public static final Integer transit_Paratransit = (Integer)VehClass.value(65571, CONV);
  
  public static final Integer transit_Paratransit_Ambulance = (Integer)VehClass.value(65572, CONV);
  
  public static final Integer emergency_TypeUnknown = (Integer)VehClass.value(65573, CONV);
  
  public static final Integer emergency_TypeOther = (Integer)VehClass.value(65574, CONV);
  
  public static final Integer emergency_Fire_Light_Vehicle = (Integer)VehClass.value(65575, CONV);
  
  public static final Integer emergency_Fire_Heavy_Vehicle = (Integer)VehClass.value(65576, CONV);
  
  public static final Integer emergency_Fire_Paramedic_Vehicle = (Integer)VehClass.value(65577, CONV);
  
  public static final Integer emergency_Fire_Ambulance_Vehicle = (Integer)VehClass.value(65578, CONV);
  
  public static final Integer emergency_Police_Light_Vehicle = (Integer)VehClass.value(65579, CONV);
  
  public static final Integer emergency_Police_Heavy_Vehicle = (Integer)VehClass.value(65580, CONV);
  
  public static final Integer emergency_Other_Responder = (Integer)VehClass.value(65581, CONV);
  
  public static final Integer emergency_Other_Ambulance = (Integer)VehClass.value(65582, CONV);
  
  public static final Integer otherTraveler_TypeUnknown = (Integer)VehClass.value(65583, CONV);
  
  public static final Integer otherTraveler_TypeOther = (Integer)VehClass.value(65584, CONV);
  
  public static final Integer otherTraveler_Pedestrian = (Integer)VehClass.value(65585, CONV);
  
  public static final Integer otherTraveler_Visually_Disabled = (Integer)VehClass.value(65586, CONV);
  
  public static final Integer otherTraveler_Physically_Disabled = (Integer)VehClass.value(65587, CONV);
  
  public static final Integer otherTraveler_Bicycle = (Integer)VehClass.value(65588, CONV);
  
  public static final Integer otherTraveler_Vulnerable_Roadworker = (Integer)VehClass.value(65589, CONV);
  
  public static final Integer infrastructure_TypeUnknown = (Integer)VehClass.value(65590, CONV);
  
  public static final Integer infrastructure_Fixed = (Integer)VehClass.value(65591, CONV);
  
  public static final Integer infrastructure_Movable = (Integer)VehClass.value(65592, CONV);
  
  public static final Integer equipped_CargoTrailer = (Integer)VehClass.value(65593, CONV);
}
