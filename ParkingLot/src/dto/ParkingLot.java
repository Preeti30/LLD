package dto;

import java.util.List;

public class ParkingLot {
    String parkingLotId;
    int numberOfFloors;
    int numberOfSlotsPerFloor;
    List<ParkingFloor> parkingFloorList;

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public int getNumberOfSlotsPerFloor() {
        return numberOfSlotsPerFloor;
    }

    public void setNumberOfSlotsPerFloor(int numberOfSlotsPerFloor) {
        this.numberOfSlotsPerFloor = numberOfSlotsPerFloor;
    }

    public List<ParkingFloor> getParkingFloorList() {
        return parkingFloorList;
    }

    public void setParkingFloorList(List<ParkingFloor> parkingFloorList) {
        this.parkingFloorList = parkingFloorList;
    }

    public ParkingLot(String id, int numOfFloors, int numOfSlotsPerFloor, List<ParkingFloor> parkingFloorList) {
        this.parkingLotId = id;
        this.numberOfFloors = numOfFloors;
        this.numberOfSlotsPerFloor = numOfSlotsPerFloor;
        this.parkingFloorList = parkingFloorList;
    }

}
