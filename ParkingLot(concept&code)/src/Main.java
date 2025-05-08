import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Parking Lot");

        Vehicle vhcoming = new Vehicle(123, VehicleType.Two_Wheeler);

        List<ParkingSlot> list= new ArrayList<>(5);

        for(int i=0;i<5;i++)
        {
            if(i%2==0){
                ParkingSlot ps = new TwoWheeler();
                list.add(ps);
            }
            else
            {
                ParkingSlot ps = new FourWheeler();
                list.add(ps);
            }

        }

        EntranceGate entranceGate = new EntranceGate();
        Ticket ticket = entranceGate.getTicket(vhcoming, list);
        ExitGate exitGate = new ExitGate(ticket);
        double price = exitGate.getTicketPrice(12);
        System.out.println(price);

    }
}