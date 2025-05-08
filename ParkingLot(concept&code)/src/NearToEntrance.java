import java.util.List;

public class NearToEntrance implements ParkingStrategy {
    public ParkingSlot findParkingSpace(List<ParkingSlot> list)
    {
        for(ParkingSlot ps:list)
        {
            if(ps.isEmpty==true)
            {
                ParkingSlot foundparkingSlot = ps;
                return ps;
            }
        }
        return null;
    }
}
