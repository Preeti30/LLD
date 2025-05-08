import Model.*;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        List<User> userList = addUsers();
        List<Vehicle> vehicleList = addVehicles();
        List<Store> storeList = addStores(vehicleList);


        CarRentalSystem carRentalSystem = new CarRentalSystem(userList, storeList);

        User comingUser = userList.get(0);
        System.out.println("User enetered is " + comingUser.getUserName());
        Location location = new Location("Gngr", 123, "Raj");
        System.out.println("Location chosen is " + location.getCity());
        Store store = carRentalSystem.getStore(location);
        System.out.println("Store presnt is " + store.getStoreId());
        List<Vehicle> vehiclesPresent = store.getVehicle(VehicleType.BIKE);
        System.out.println("These are the vehicles present");
        for(int i=0;i<vehiclesPresent.size();i++)
        {
            System.out.println(vehiclesPresent.get(i).getVehicleNumber());
        }
        Reservation reservation = store.reserveVehicle(vehiclesPresent.get(0), comingUser);
        System.out.println("Your reservation is done");
        System.out.println("Reservation Details are " + reservation.reservationID + reservation.reservationType +
                reservation.vehicle + reservation.reservationStatus);
        Bill bill = new Bill(reservation);

        Payment payment = new Payment();
        System.out.println("please pay amount of "+ bill.billAmount);
        payment.payAmount(bill);

        boolean ans = store.completeReservation(reservation.reservationID);
        if(ans)
        {
            System.out.println("Resr completed");
        }
        else
        {
            System.out.println("Errr");
        }
    }
        public static List<Vehicle> addVehicles (){
            List<Vehicle> vehicles = new ArrayList<>();
            Vehicle vehicle1 = new Vehicle(12, 13, 11, 34, 4, 5, VehicleType.BIKE);
            Vehicle vehicle2 = new Vehicle(15, 23, 21, 38, 4, 5, VehicleType.BIKE);
            vehicles.add(vehicle1);
            vehicles.add(vehicle2);
            return vehicles;
        }

        public static List<Store> addStores (List<Vehicle> vehicleList) {
            List<Store> storeList = new ArrayList<>();
            Store store1 = new Store(1, new Location("Gngr", 123, "Raj"));
            Store store2 = new Store(2, new Location("Bika", 456, "Raj"));
            storeList.add(store1);
            storeList.add(store2);
            store1.setVehicles(vehicleList);
            return storeList;
        }

        public static List<User> addUsers() {
            List<User> userList = new ArrayList<>();
            User user1 = new User(1, "Preeti");
            User user2 = new User(2, "Ruchi");
            userList.add(user1);
            userList.add(user2);
            return userList;
        }
    }
