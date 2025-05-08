package service;

import dto.ParkingFloor;
import dto.ParkingSlot;
import dto.Ticket;
import dto.Vehicle;
import enums.ParkingSlotStatus;
import enums.VehicleType;

import java.util.List;
import java.util.stream.Collectors;

public class ParkingFloorService {

    //Display the count of free slots for each vehicle
    static int getFreeSlotsCount(ParkingFloor parkingFloor, VehicleType vehicleType) {
        List<ParkingSlot> parkingSlotList = parkingFloor.getParkingSlotList();
        int count =(int)parkingSlotList.stream().filter(slot->slot.getParkingSlotStatus().equals(ParkingSlotStatus.AVAILABLE)
                && slot.getVehicleType().equals(vehicleType)).count();
        return count;

    }

    //Display the ids of all the free parking slots
    static void getFreeSlots(ParkingFloor parkingFloor, VehicleType vehicleType) {
        List<ParkingSlot> parkingSlotList = parkingFloor.getParkingSlotList();
        parkingSlotList.stream().filter(parkingSlot -> parkingSlot.getParkingSlotStatus().equals(ParkingSlotStatus.AVAILABLE)
        &&parkingSlot.getVehicleType().equals(vehicleType)).forEach(parkingSlot -> {System.out.println(parkingSlot.getId());});
    }

    //Display the ids of all the occupied parking slots
    static void getOccupiedSlots(ParkingFloor parkingFloor, VehicleType vehicleType) {

        List<ParkingSlot> parkingSlotList = parkingFloor.getParkingSlotList();
        parkingSlotList.stream().filter(parkingSlot -> parkingSlot.getVehicleType().equals(vehicleType)
        &&parkingSlot.getParkingSlotStatus().equals(ParkingSlotStatus.UNAVAILABLE)).forEach(parkingSlot -> {System.out.println(parkingSlot.getId());});

    }

    static Ticket allotSlot(ParkingFloor parkingFloor, Vehicle vehicle)
    {
        List<ParkingSlot> parkingSlotList = parkingFloor.getParkingSlotList();
        List<ParkingSlot> availableParkingSlot = parkingSlotList.stream().filter(parkingSlot -> parkingSlot.getVehicleType().equals(vehicle.getVehicleType()) &&
                parkingSlot.getParkingSlotStatus().equals(ParkingSlotStatus.AVAILABLE)).collect(Collectors.toList());
        if(availableParkingSlot.size() !=0)
        {
            ParkingSlot parkingSlot = availableParkingSlot.get(0);
            ParkingSlotService parkingSlotService = new ParkingSlotService(parkingSlot);
            Ticket ticket = parkingSlotService.allotSlot(parkingSlot, vehicle);
            return ticket;
        }
        else {
            return null;
        }
    }

}
