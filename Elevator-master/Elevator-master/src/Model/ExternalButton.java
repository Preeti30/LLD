package Model;

public class ExternalButton {

    ExternalButtonDispatcher externalButtonDispatcher;

    public void submitRequest(int floor, Direction d)
    {
        externalButtonDispatcher.acceptRequest(floor, d);
    }
}
