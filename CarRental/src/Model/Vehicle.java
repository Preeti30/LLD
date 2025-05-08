package Model;

public class Vehicle {

    public void setVehicleNumber(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setDailyRate(int dailyRate) {
        this.dailyRate = dailyRate;
    }

    int vehicleNumber;
    int modelNumber;
    int cc;

    public int getAverage() {
        return average;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public int getModelNumber() {
        return modelNumber;
    }

    public int getCc() {
        return cc;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public int getDailyRate() {
        return dailyRate;
    }

    int average;

    public Vehicle(int vehicleNumber, int modelNumber, int cc, int average, int hourlyRate, int dailyRate, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.modelNumber = modelNumber;
        this.cc = cc;
        this.average = average;
        this.hourlyRate = hourlyRate;
        this.dailyRate = dailyRate;
        this.vehicleType = vehicleType;
    }

    int hourlyRate;
    int dailyRate;

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    VehicleType vehicleType;


}
