package Model;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ElevatorController {

    Elevator elevator;
    PriorityQueue<Integer> minUpPQ;
    PriorityQueue<Integer> maxDownPQ;
    Queue<Request> pendingRequests;


    public ElevatorController(Elevator elevator)
    {
        this.elevator = elevator;
        minUpPQ = new PriorityQueue<>();
        maxDownPQ = new PriorityQueue<>();
        pendingRequests = new LinkedList<>();
    }
    public void submitExternalRequest(int floor, Direction direction)
    {
        if(direction == Direction.UP)
        {
            if(floor>elevator.currentFloor) {
                minUpPQ.add(floor);
            }
            else
            {
                pendingRequests.add(new Request(floor, direction));
            }
        }
        else {
            if(floor<elevator.currentFloor)
            {
                maxDownPQ.add(floor);
            }
            else
            {
                pendingRequests.add(new Request(floor, direction));
            }
        }
    }

    public void submitInternalRequest(int floor)
    {
        if(floor>elevator.currentFloor)
        {
            minUpPQ.offer(floor);
        }
        else if(floor<elevator.currentFloor) {
            maxDownPQ.offer(floor);
        }
    }

    public void controlElevator()
    {
        while(true)
        {
            if(elevator.elevatorDirection == Direction.UP)
            {
                processUpRequests();
            }
            else if(elevator.elevatorDirection == Direction.DOWN)
            {
                processDownRequests();
            }
            else
            {
                decidenextIteration();
            }
        }
    }


    private void processDownRequests() {
        while(!maxDownPQ.isEmpty() || hasEligiblePendingReq(Direction.DOWN))
        {
            if(!maxDownPQ.isEmpty())
            {
                int nextFloor = maxDownPQ.poll();
                moveToFloor(nextFloor);
            }
            else {
                processPendingRequest(Direction.DOWN);
            }
        }

    }

    private void processUpRequests() {
        while(!minUpPQ.isEmpty() || hasEligiblePendingReq(Direction.UP)) {
            if (!minUpPQ.isEmpty()) {
                int nextFloor = minUpPQ.poll();
                moveToFloor(nextFloor);
            } else {
                processPendingRequest(Direction.UP);
            }
        }
        elevator.elevatorDirection = Direction.DOWN;
    }

    private void processPendingRequest(Direction direction) {
            Queue<Request> remainingRequest = new LinkedList<>();
            while(!pendingRequests.isEmpty())
            {
                Request request = pendingRequests.poll();
                if(request.direction == direction &&
                        (direction == Direction.UP && request.floor>elevator.currentFloor) ||
                        (direction ==Direction.DOWN && request.floor < elevator.currentFloor))
                {
                    if(direction == Direction.UP)
                    {
                        minUpPQ.offer(request.floor);
                    }
                    else
                    {
                        maxDownPQ.offer(request.floor);
                    }
                }
                else
                {
                    remainingRequest.add(request);
                }
            }
            pendingRequests = remainingRequest;
    }

    private void moveToFloor(int nextFloor) {

        System.out.println("Moving to floor" + nextFloor);
        elevator.currentFloor = nextFloor;
    }

    private boolean hasEligiblePendingReq(Direction direction) {
        for(Request request:pendingRequests)
        {
            if(request.direction == direction && (direction == Direction.DOWN && request.floor < elevator.currentFloor) ||
                    (direction == Direction.UP && request.floor>elevator.currentFloor))
            {
                return true;
            }
        }
        return false;
    }

    static class Request
    {
        int floor;
        Direction direction;
        Request(int floor, Direction direction)
        {
            this.floor = floor;
            this.direction = direction;
        }
    }


    private void  decidenextIteration() {
        if(!minUpPQ.isEmpty() || hasEligiblePendingReq(Direction.UP))
        {
            elevator.elevatorDirection = Direction.UP;
        }
        else if(!maxDownPQ.isEmpty() || hasEligiblePendingReq(Direction.DOWN))
        {
            elevator.elevatorDirection = Direction.DOWN;
        }
    }
}

