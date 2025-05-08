package repository;

import dto.ParkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotRepository {
    public static Map<String,ParkingLot> getParkingLotRepositoryMap() {
        return parkingLotRepositoryMap;
    }

    public static void setParkingLotRepositoryMap(Map<String,ParkingLot> parkingLotRepositoryMap) {
        ParkingLotRepository.parkingLotRepositoryMap = parkingLotRepositoryMap;
    }

    public static List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public static void setParkingLotList(List<ParkingLot> parkingLotList) {
        ParkingLotRepository.parkingLotList = parkingLotList;
    }

    static Map<String, ParkingLot> parkingLotRepositoryMap;
    public static List<ParkingLot> parkingLotList;

    public ParkingLotRepository() {
        parkingLotRepositoryMap = new HashMap<>();
        parkingLotList = new ArrayList<>();
    }
}
