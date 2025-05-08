package dto;

import enums.ParkingSlotStatus;
import enums.VehicleType;

public class ParkingSlot {
    String id;
    VehicleType vehicleType;
    ParkingSlotStatus parkingSlotStatus;
    String ParkingLot;
    int parkingFloorNumber;
    Ticket ticket;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingSlotStatus getParkingSlotStatus() {
        return parkingSlotStatus;
    }

    public void setParkingSlotStatus(ParkingSlotStatus parkingSlotStatus) {
        this.parkingSlotStatus = parkingSlotStatus;
    }

    public String getParkingLot() {
        return ParkingLot;
    }

    public void setParkingLot(String parkingLot) {
        ParkingLot = parkingLot;
    }

    public int getParkingFloorNumber() {
        return parkingFloorNumber;
    }

    public ParkingSlot(String id,VehicleType vehicleType, ParkingSlotStatus parkingSlotStatus, String parkingLot, int parkingFloorNumber) {
            this.vehicleType = vehicleType;
            this.parkingSlotStatus = parkingSlotStatus;
            this.id = id;
            this.ParkingLot = parkingLot;
            this.parkingFloorNumber = parkingFloorNumber;
    }

    public void setParkingFloorNumber(int parkingFloorNumber) {
        this.parkingFloorNumber = parkingFloorNumber;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }




}
