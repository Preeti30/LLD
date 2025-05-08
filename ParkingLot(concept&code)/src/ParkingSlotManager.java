import java.util.List;

public class ParkingSlotManager {

    private
        List<ParkingSlot> parkingSlotList;
        ParkingStrategy pstrategy;
        ParkingSlot parkingSlot;

    public

        ParkingSlotManager(List<ParkingSlot> list, ParkingStrategy ps){
            this.parkingSlotList = list;
            this.pstrategy = ps;
        }

        void parkVehicle(ParkingSlot ps, Vehicle vhcoming)
        {
            ps.isEmpty = false;
            ps.setV(vhcoming);
        }

        ParkingSlot findParkingSpace(List<ParkingSlot> list)
        {
            ParkingSlot pslot = pstrategy.findParkingSpace(list);
            return pslot;
        }

}
