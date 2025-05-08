package Model;

public class Elevator {

    int id;
    Display display;
    InternalButton internalButton;
    ElevatorStatus elevatorStatus;
    int currentFloor;
    Direction elevatorDirection;
    ElevatorDoor door;

    public Elevator()
    {
        display = new Display(0, Direction.UP);
        internalButton = new InternalButton();
        elevatorStatus = ElevatorStatus.IDLE;
        currentFloor =0;
        elevatorDirection = Direction.UP;
        door = new ElevatorDoor();
    }
    public void acceptRequest(int floor, Direction direction)
    {
        elevatorController.acceptRequest(floor, direction);
    }

    public void showDisplay()
    {
        display.showDisplay();
    }

    public void setDisplay(int floor, Direction d)
    {
        display.setDisplay(floor,d);
    }
    public void pressButton(int destination)
    {
        internalButton.pressButton(destination, this);
    }

    boolean moveElevator(int destination, Direction direction)
    {
        int startFloor = currentFloor;
        for(int i=startFloor; i<destination;i++) {
            if (direction == Direction.UP) {
                setDisplay(i, direction);
                showDisplay();
                if(i==destination)
                    return true;
            }
            if (direction == Direction.DOWN) {
                setDisplay(i, direction);
                showDisplay();
                if(i==destination)
                    return true;
            }
        }
        return false;
    }
}
