package Model;

public class Display {

    public Display(int currentFloor, Direction d) {
        this.currentFloor = currentFloor;
        this.d = d;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getD() {
        return d;
    }

    public void setD(Direction d) {
        this.d = d;
    }

    int currentFloor;
    Direction d;

    public void showDisplay()
    {
        System.out.println("Current floor is " + currentFloor);
        System.out.println("Current direction is " + d);
    }

    public void setDisplay(int currentFloor, Direction d)
    {
        this.currentFloor = currentFloor;
        this.d = d;
    }

}
