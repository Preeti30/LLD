package Model;

import java.util.ArrayList;
import java.util.List;

public class ElevatorCreator {

    static List<ElevatorController> elevatorControllerList = new ArrayList<>();
    static {
        Elevator elevator1 = new Elevator();
        elevator1.id = 1;
        ElevatorController elevatorController1 = new ElevatorController(elevator1);

        Elevator elevator2 = new Elevator();
        elevator2.id = 1;
        ElevatorController elevatorController2 = new ElevatorController(elevator2);

        elevatorControllerList.add(elevatorController1);
        elevatorControllerList.add(elevatorController2);

    }
}
