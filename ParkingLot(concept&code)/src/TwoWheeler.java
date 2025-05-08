public class TwoWheeler extends ParkingSlot{
    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    double price = super.price+10;

    public TwoWheeler() {
        super.isEmpty = true;
    }
}
