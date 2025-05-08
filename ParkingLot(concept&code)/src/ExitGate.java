public class ExitGate {
    CostComputationStrategy costComputationStrategy;

    public ExitGate(Ticket ticket) {
        if(ticket.getParkingSlot().getV().vehicleType == VehicleType.Two_Wheeler)
        {
            costComputationStrategy = new TwoWheelerCostComputationStrategy();
        }
        else if(ticket.getParkingSlot().getV().vehicleType == VehicleType.Four_Wheeler)
        {
            costComputationStrategy = new FourWheelerCostComputationStrategy();
        }
    }

    double getTicketPrice(double exitTime)
    {
        return costComputationStrategy.calculateCost();
    }
}
