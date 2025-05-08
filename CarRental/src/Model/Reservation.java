package Model;

public class Reservation {

    public User user;
    public Vehicle vehicle;

    public Reservation(User user, Vehicle vehicle, int reservationID, ReservationStatus reservationStatus, ReservationType reservationType) {
        this.user = user;
        this.vehicle = vehicle;
        this.reservationID = reservationID;
        this.reservationStatus = reservationStatus;
        this.reservationType = reservationType;
    }

    public int reservationID;
    public ReservationType reservationType;
    public ReservationStatus reservationStatus;

}
