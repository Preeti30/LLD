package Model;

import java.util.List;

public class VehicleMgmtSystem {

    public VehicleMgmtSystem(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    List<Vehicle> vehicleList;

    public void addVehicle(Vehicle vehicle)
    {
        vehicleList.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle)
    {
        vehicleList.remove(vehicle);
    }
}
