import Constants.Commands;
import enums.DisplayType;
import enums.VehicleType;
import service.InMemoryService;
import service.ParkingLotService;
import util.VehicleUtil;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Application {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        InMemoryService inMemoryService = new InMemoryService();
        ParkingLotService parkingLotService = new ParkingLotService();

        while (true) {
            String[] input = sc.nextLine().trim().split(" ");
            try {
                switch (input[0]) {
                    case Commands.CREATE: {
                        parkingLotService.create_parking_lot(input[1], Integer.parseInt(input[2]), Integer.parseInt(input[3]));
                    }
                    break;

                    case Commands.DISPLAY: {
                        parkingLotService.display(DisplayType.valueOf(input[1]), VehicleType.valueOf(input[2]));
                    }
                    break;

                    case Commands.PARK: {
                        parkingLotService.parkVehicle(VehicleUtil.generateVehicleDTO(VehicleType.valueOf(input[1]), input[2], input[3]));
                    }
                    break;
                    case Commands.UNPARK: {
                        parkingLotService.unparkVehicle(input[1]);
                    }
                    break;
                    case Commands.EXIT: {
                        System.exit(0);
                    }
                    break;
                    default: {
                        System.out.println("Invalid command");
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}