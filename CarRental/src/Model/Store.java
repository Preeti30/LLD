package Model;

import java.util.ArrayList;
import java.util.List;

public class Store {

    public Store(int storeId, Location location) {
        this.storeId = storeId;
        this.location = location;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    int storeId;

    public Location getLocation() {
        return location;
    }

    public int getStoreId() {
        return storeId;
    }

    Location location;



    VehicleMgmtSystem vehicleMgmtSystem;
    List<Reservation> reservationList = new ArrayList<>();


    public List<Vehicle> getVehicle(VehicleType vehicleType) {
        return vehicleMgmtSystem.getVehicleList();
    }

    public void setVehicles(List<Vehicle> vehicles)
    {
        vehicleMgmtSystem = new VehicleMgmtSystem(vehicles);
    }

    public List<Vehicle> getVehicles()
    {
        return vehicleMgmtSystem.getVehicleList();
    }

    public Reservation reserveVehicle(Vehicle vehicle, User user)
    {
            Reservation reservation = new Reservation(user, vehicle, 1, ReservationStatus.SCHEDULED, ReservationType.HOURLY);
            return reservation;
    }
    public boolean completeReservation(int reservationID)
    {
        return true;
    }
}
