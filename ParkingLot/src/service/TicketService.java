package service;

import dto.ParkingSlot;
import dto.Ticket;
import dto.Vehicle;
import repository.TicketRepository;

public class TicketService  {
    static Ticket generateTicket(ParkingSlot parkingSlot, Vehicle vehicle)
    {
        String ticket_id = generateTicketId(parkingSlot);
        Ticket ticket = new Ticket(ticket_id, parkingSlot, vehicle);
        TicketRepository.getTicketMap().put(ticket_id, ticket);
        return ticket;

    }
    static String generateTicketId(ParkingSlot parkingSlot)
    {
        return String.valueOf(parkingSlot.getParkingLot() + "_" + parkingSlot.getParkingFloorNumber() + "_" + parkingSlot.getId());

    }

    static Ticket getTicketByTicketId(String ticket_id)
    {
        if(TicketRepository.getTicketMap().containsKey(ticket_id))
            return TicketRepository.getTicketMap().get(ticket_id);
        return null;
    }

    static void deleteTicket(String ticket_id)
    {
        TicketRepository.getTicketMap().remove(ticket_id);
    }
}
