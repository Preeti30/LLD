public class Vehicle {
    private
    int VehicleNumber;
    VehicleType vehicleType;


    public Vehicle(int vehicleNumber, VehicleType vehicleType) {
        this.VehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }


    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(int vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }




}
