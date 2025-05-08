package service;

import repository.ParkingFloorRepository;
import repository.ParkingLotRepository;
import repository.ParkingSlotRepository;
import repository.TicketRepository;

public class InMemoryService {
    ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
    ParkingSlotRepository parkingSlotRepository = new ParkingSlotRepository();
    ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
    TicketRepository ticketRepository = new TicketRepository();
}
