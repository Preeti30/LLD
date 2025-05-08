package service;

import dto.ParkingSlot;
import dto.Ticket;
import dto.Vehicle;
import enums.ParkingSlotStatus;

//encapsulates operations related to parking slots, such as allotting and un-allotting (freeing) a slot
public class ParkingSlotService {

    ParkingSlot parkingSlot;
    public ParkingSlotService(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }
    Ticket allotSlot(ParkingSlot parkingSlot, Vehicle vehicle) {
        parkingSlot.setParkingSlotStatus(ParkingSlotStatus.UNAVAILABLE);
        Ticket ticket = TicketService.generateTicket(parkingSlot, vehicle);
        parkingSlot.setTicket(ticket);
        return ticket;
    }

    void unallotSlot(ParkingSlot parkingSlot, Vehicle vehicle){
        parkingSlot.setParkingSlotStatus(ParkingSlotStatus.AVAILABLE);
        parkingSlot.setTicket(null);
    }
}
