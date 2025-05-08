import java.util.List;

public class EntranceGate {
    Vehicle vehicle;
    ParkingSlotManager parkingSlotManager;
    ParkingSlot parkingSlot;
    ParkingSlotManagerFactory parkingSlotManagerFactory = new ParkingSlotManagerFactory();
    static int ticketId = 1;

    Ticket generateTicket(ParkingSlot parkingSlot)
    {
        Ticket t = new Ticket(ticketId++, 12, parkingSlot);
        return t;
    }

    public Ticket getTicket(Vehicle vhcoming, List<ParkingSlot> list) {

        ParkingSlotManager parkingSlotManager = parkingSlotManagerFactory.getParkingSlotManagerObject(vhcoming, list);
        ParkingSlot parkingSlot = parkingSlotManager.findParkingSpace(list);
        parkingSlotManager.parkVehicle(parkingSlot, vhcoming);//TwoWheelerMgr
        Ticket newTicket = generateTicket(parkingSlot);
        return newTicket;
    }
}
