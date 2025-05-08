public class Ticket {

    int number;

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    ParkingSlot parkingSlot;
    CostComputationStrategy costComputationStrategy;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = costComputationStrategy.calculateCost();
    }

    double price;

    public double getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(double entryTime) {
        this.entryTime = entryTime;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    double entryTime;

    public Ticket(int number, double entryTime, ParkingSlot parkingSlot) {
        this.number = number;
        this.entryTime = entryTime;
        this.parkingSlot = parkingSlot;
    }

}
