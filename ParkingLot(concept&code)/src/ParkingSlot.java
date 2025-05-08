public class ParkingSlot {
    int id;
    Vehicle v;

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehicle getV() {
        return v;
    }

    public void setV(Vehicle v) {
        this.v = v;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    boolean isEmpty;
    double price;
}
