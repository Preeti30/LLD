package Model;

public class Location {

    String city;

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public int getPin() {
        return pin;
    }

    String state;

    public Location(String city, int pin, String state) {
        this.city = city;
        this.pin = pin;
        this.state = state;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    int pin;
}
