package ParkingLot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ParkingLot parkingLot = null;

        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] commands = line.split(" ");

            String main = commands[0];

            switch (main) {
                case "create_parking_lot":
                    int floors = 0, slots = 0;
                    try {
                        floors = Integer.parseInt(commands[2]);
                        slots = Integer.parseInt(commands[3]);
                    } catch (NumberFormatException e) {
                        System.out.println("Give valid floor or slots number :" + e);
                        break;
                    }
                    parkingLot = new ParkingLot(commands[1], floors, slots);
                    break;
                case "display":
                    switch (commands[1]) {
                        case "free_count":
                            displayFreeCount(parkingLot);
                            break;
                        case "free_slots":
                            displayFreeSlots(parkingLot);
                            break;
                        case "occupied_slots":
                            displayOccupiedSlots(parkingLot);
                            break;
                        default:
                            System.out.println("Inavlid command");
                    }
                case "park_vehicle":
                    try {
                        VechicleType type = VechicleType.valueOf(commands[1]);
                        String regNo = commands[2];
                        String color = commands[3];
                        parkingLot.park(type, regNo, color);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid command");
                    }
                    break;
                case "unpark_vehicle":
                    String strTicket = commands[1];
                    parkingLot.unpark(strTicket);
                    break;
                case "exit":
                    return;
            }
        }

    }

    private static void displayFreeSlots(ParkingLot parkingLot) {
        if(parkingLot==null){
            System.out.println("create parking lot first");
        }
    }

    private static void displayFreeCount(ParkingLot parkingLot) {
        if(parkingLot==null){
            System.out.println("create parking lot first");
        }
    }

    private static void displayOccupiedSlots(ParkingLot parkingLot) {
        if(parkingLot==null){
            System.out.println("create parking lot first");
        }
    }
}