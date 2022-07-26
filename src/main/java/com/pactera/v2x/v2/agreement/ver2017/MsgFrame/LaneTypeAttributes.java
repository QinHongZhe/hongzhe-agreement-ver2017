package com.pactera.v2x.v2.agreement.ver2017.MsgFrame;

import org.asnlab.asndt.runtime.conv.AnnotationChoiceConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ChoiceConverter;
import org.asnlab.asndt.runtime.conv.annotation.Alternative;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 定义不同类别车道的属性集合。
 */
public class LaneTypeAttributes {
  public static final int vehicleChosen = 0;
  
  public static final int crosswalkChosen = 1;
  
  public static final int bikeLaneChosen = 2;
  
  public static final int sidewalkChosen = 3;
  
  public static final int medianChosen = 4;
  
  public static final int stripingChosen = 5;
  
  public static final int trackedVehicleChosen = 6;
  
  public static final int parkingChosen = 7;
  
  public final int choiceID;
  
  @Alternative(0)
  public final LaneAttributes_Vehicle vehicle;
  
  @Alternative(1)
  public final LaneAttributes_Crosswalk crosswalk;
  
  @Alternative(2)
  public final LaneAttributes_Bike bikeLane;
  
  @Alternative(3)
  public final LaneAttributes_Sidewalk sidewalk;
  
  @Alternative(4)
  public final LaneAttributes_Barrier median;
  
  @Alternative(5)
  public final LaneAttributes_Striping striping;
  
  @Alternative(6)
  public final LaneAttributes_TrackedVehicle trackedVehicle;
  
  @Alternative(7)
  public final LaneAttributes_Parking parking;
  
  private LaneTypeAttributes(int choiceID, LaneAttributes_Vehicle vehicle, LaneAttributes_Crosswalk crosswalk, LaneAttributes_Bike bikeLane, LaneAttributes_Sidewalk sidewalk, LaneAttributes_Barrier median, LaneAttributes_Striping striping, LaneAttributes_TrackedVehicle trackedVehicle, LaneAttributes_Parking parking) {
    this.choiceID = choiceID;
    this.vehicle = vehicle;
    this.crosswalk = crosswalk;
    this.bikeLane = bikeLane;
    this.sidewalk = sidewalk;
    this.median = median;
    this.striping = striping;
    this.trackedVehicle = trackedVehicle;
    this.parking = parking;
  }
  
  public static LaneTypeAttributes vehicle(LaneAttributes_Vehicle vehicle) {
    return new LaneTypeAttributes(0, vehicle, null, null, null, null, null, null, null);
  }
  
  public static LaneTypeAttributes crosswalk(LaneAttributes_Crosswalk crosswalk) {
    return new LaneTypeAttributes(1, null, crosswalk, null, null, null, null, null, null);
  }
  
  public static LaneTypeAttributes bikeLane(LaneAttributes_Bike bikeLane) {
    return new LaneTypeAttributes(2, null, null, bikeLane, null, null, null, null, null);
  }
  
  public static LaneTypeAttributes sidewalk(LaneAttributes_Sidewalk sidewalk) {
    return new LaneTypeAttributes(3, null, null, null, sidewalk, null, null, null, null);
  }
  
  public static LaneTypeAttributes median(LaneAttributes_Barrier median) {
    return new LaneTypeAttributes(4, null, null, null, null, median, null, null, null);
  }
  
  public static LaneTypeAttributes striping(LaneAttributes_Striping striping) {
    return new LaneTypeAttributes(5, null, null, null, null, null, striping, null, null);
  }
  
  public static LaneTypeAttributes trackedVehicle(LaneAttributes_TrackedVehicle trackedVehicle) {
    return new LaneTypeAttributes(6, null, null, null, null, null, null, trackedVehicle, null);
  }
  
  public static LaneTypeAttributes parking(LaneAttributes_Parking parking) {
    return new LaneTypeAttributes(7, null, null, null, null, null, null, null, parking);
  }
  
  public boolean equals(Object obj) {
    if (!(obj instanceof LaneTypeAttributes))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static LaneTypeAttributes per_decode(boolean align, InputStream in) throws IOException {
    return (LaneTypeAttributes)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = MsgFrame.type(1114216);
  
  public static final ChoiceConverter CONV = (ChoiceConverter)new AnnotationChoiceConverter(LaneTypeAttributes.class);
  
  static {
    AsnConverter vehicleConverter = LaneAttributes_Vehicle.CONV;
    AsnConverter crosswalkConverter = LaneAttributes_Crosswalk.CONV;
    AsnConverter bikeLaneConverter = LaneAttributes_Bike.CONV;
    AsnConverter sidewalkConverter = LaneAttributes_Sidewalk.CONV;
    AsnConverter medianConverter = LaneAttributes_Barrier.CONV;
    AsnConverter stripingConverter = LaneAttributes_Striping.CONV;
    AsnConverter trackedVehicleConverter = LaneAttributes_TrackedVehicle.CONV;
    AsnConverter parkingConverter = LaneAttributes_Parking.CONV;
    CONV.setAlternativeConverters(new AsnConverter[] { vehicleConverter, crosswalkConverter, bikeLaneConverter, sidewalkConverter, medianConverter, stripingConverter, trackedVehicleConverter, parkingConverter });
  }
}
