package repository;

import dto.ParkingSlot;

import java.util.HashMap;
import java.util.Map;

public class ParkingSlotRepository {
    public static Map<String,ParkingSlot> getParkingSlotRepositoryMap() {
        return parkingSlotRepositoryMap;
    }

    public static void setParkingSlotRepositoryMap(Map<String,ParkingSlot> parkingSlotRepositoryMap) {
        ParkingSlotRepository.parkingSlotRepositoryMap = parkingSlotRepositoryMap;
    }

    public static Map<String, ParkingSlot> parkingSlotRepositoryMap;

    public ParkingSlotRepository() {
        parkingSlotRepositoryMap = new HashMap<>();

    }

}
