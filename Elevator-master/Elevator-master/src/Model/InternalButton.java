package Model;

public class InternalButton {
    InternalButtonDispatcher internalButtonDispatcher;

    public void pressButton(int destination, Elevator elevator)
    {
        internalButtonDispatcher.submitRequest(destination, elevator);
    }
}
