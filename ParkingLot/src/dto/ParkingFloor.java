package dto;

import java.util.List;

public class ParkingFloor {
    int floorNo;

    public String getParkingLot_id() {
        return parkingLot_id;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public void setParkingLot_id(String parkingLot_id) {
        this.parkingLot_id = parkingLot_id;
    }

    String parkingLot_id;

    public List<ParkingSlot> getParkingSlotList() {
        return parkingSlotList;
    }

    public ParkingFloor(int floorNo, String parkingLot_id, List<ParkingSlot> parkingSlotList) {
            this.floorNo = floorNo;
            this.parkingLot_id = parkingLot_id;
            this.parkingSlotList = parkingSlotList;
    }

    public void setParkingSlotList(List<ParkingSlot> parkingSlotList) {
        this.parkingSlotList = parkingSlotList;
    }

    List<ParkingSlot> parkingSlotList;

}
