package service;

import dto.*;
import enums.ParkingSlotStatus;
import enums.VehicleType;
import enums.DisplayType;
import repository.ParkingLotRepository;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotService {
    List<ParkingLot> parkingLotList = ParkingLotRepository.getParkingLotList();

    public void create_parking_lot(String parking_lot_id, int no_of_floors, int no_of_slots_per_floor)
    {
        List<ParkingFloor>parkingFloorList = new ArrayList<>(no_of_floors);
        for(int i=0;i<no_of_floors;i++)
        {
            List<ParkingSlot> parkingSlotList = new ArrayList<>(no_of_slots_per_floor);
            for(int j=0;j<no_of_slots_per_floor;j++)
            {
                ParkingSlot parkingSlot = new ParkingSlot(String.valueOf(j+1), VehicleType.CAR, ParkingSlotStatus.AVAILABLE,parking_lot_id,i+1);
                if(j==0)
                    parkingSlot.setVehicleType(VehicleType.TRUCK);
                else if(j==1 || j==2)
                    parkingSlot.setVehicleType(VehicleType.BIKE);
                parkingSlotList.add(parkingSlot);
            }
            ParkingFloor parkingFloor = new ParkingFloor(i+1,parking_lot_id,parkingSlotList);
            parkingFloorList.add(parkingFloor);
        }
        ParkingLot parkingLot = new ParkingLot(parking_lot_id, no_of_floors, no_of_slots_per_floor, parkingFloorList);
        ParkingLotRepository.getParkingLotRepositoryMap().put(parking_lot_id, parkingLot);
        ParkingLotRepository.getParkingLotList().add(parkingLot);

    }
    //This method is responsible for parking a given vehicle in the first available slot in the parking lot.
    // If no slot is available, it informs the user that the parking lot is full.

    public void parkVehicle(Vehicle vehicle)
    {
        ParkingLot parkingLot =parkingLotList.get(0);
        List<ParkingFloor> parkingFloorList = parkingLot.getParkingFloorList();

        int floorFullCount = 0;
        for(ParkingFloor parkingFloor:parkingFloorList)
        {
            if(ParkingFloorService.getFreeSlotsCount(parkingFloor, vehicle.getVehicleType())>0)
            {
                Ticket allotmentTicket =ParkingFloorService.allotSlot(parkingFloor, vehicle);
                if(allotmentTicket!=null)
                {
                    System.out.println("Parked Vehicle.Ticket ID" +allotmentTicket.getId());
                    break;
                }
                else
                {
                    floorFullCount++;
                }
            }
        }
        if(floorFullCount==parkingLot.getParkingFloorList().size())
        {
            System.out.println("Parking Lot is Full");
        }
    }


    public void unparkVehicle(String ticketId)
    {
        ParkingLot parkingLot =ParkingLotRepository.getParkingLotList().get(0);
        Ticket ticket =TicketService.getTicketByTicketId(ticketId);
        ParkingSlot parkingSlot = ticket.getParkingSlot();
        Vehicle vehicle = ticket.getVehicle();
        ParkingSlotService parkingSlotService = new ParkingSlotService(parkingSlot);
        parkingSlotService.unallotSlot(parkingSlot, vehicle);
        TicketService.deleteTicket(ticketId);
        System.out.println("Unparked vehicle with Registration Number: " +vehicle.getRegNo() + "and color: " + vehicle.getColor());
    }

    public void display(DisplayType displayType, VehicleType vehicleType )
    {
        ParkingLot parkingLot = ParkingLotRepository.getParkingLotList().get(0);
        List<ParkingFloor> parkingFloorList = parkingLot.getParkingFloorList();

        int parkingFloorIndex = 0;
        for(ParkingFloor parkingFloor:parkingFloorList)
        {
            if(displayType.equals(DisplayType.free_count))
            {
                int freeSlotsCount = ParkingFloorService.getFreeSlotsCount(parkingFloor, vehicleType);
                System.out.println("No. of free slots:" +vehicleType+" on floor "+parkingFloorIndex+": " +freeSlotsCount);
            }
            else if(displayType.equals(DisplayType.free_slots))
            {
                System.out.print("Free slots for "+ vehicleType+" on Floor "+parkingFloorIndex+": ");
                ParkingFloorService.getFreeSlots(parkingFloor,vehicleType);
                System.out.println();
            }
            else if (displayType.equals(DisplayType.occupied_slots)){
                System.out.print("Occupied slots for "+ vehicleType+"on Floor "+parkingFloorIndex+": ");
                ParkingFloorService.getOccupiedSlots(parkingFloor, vehicleType);
                System.out.println();
            }
        }
    }


}
