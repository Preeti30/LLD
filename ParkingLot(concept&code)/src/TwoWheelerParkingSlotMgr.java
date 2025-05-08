import java.util.ArrayList;
import java.util.List;

public class TwoWheelerParkingSlotMgr extends ParkingSlotManager {

    //List<ParkingSlot> parkingSlotList;
    public TwoWheelerParkingSlotMgr(List<ParkingSlot> parkingSlotList)
    {
            super(parkingSlotList, new NearToEntrance());
    }


}
