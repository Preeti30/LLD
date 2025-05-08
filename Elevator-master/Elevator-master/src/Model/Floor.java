package Model;

public class Floor {
    int floorNumber;

    public Floor(int floorNumber, ExternalButton externalButton) {
        this.floorNumber = floorNumber;
        this.externalButtonDispatcher = externalButton.externalButtonDispatcher;
    }

    ExternalButtonDispatcher externalButtonDispatcher;

    public void pressButton(Direction direction)
    {
        externalButtonDispatcher.submitExternalRequest(floorNumber, direction);
    }
}
