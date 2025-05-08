import java.util.List;

public class ParkingSlotManagerFactory {
    ParkingSlotManager psm;

    ParkingSlotManager getParkingSlotManagerObject(Vehicle v, List<ParkingSlot> list)
    {
        if(v.vehicleType==VehicleType.Two_Wheeler)
        {
            ParkingSlotManager psm = new TwoWheelerParkingSlotMgr(list);
            return psm;
        }
//        else if(v.vehicleType==VehicleType.Four_Wheeler)
//        {
//            ParkingSlotManager psm = new FourWheelerParkingSlotMgr(list);
//            return psm;
//        }
        return null;
    }
}
