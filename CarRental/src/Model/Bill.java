package Model;

public class Bill {
    Reservation reservation;
    public int billAmount;

    public Bill(Reservation reservation)
    {
        this.reservation = reservation;
        billAmount = createBill(reservation);
    }

    public int createBill(Reservation reservation)
    {
        int amount = reservation.vehicle.hourlyRate;
        return amount;
    }
}
