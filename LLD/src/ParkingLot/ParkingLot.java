package ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    List<ParkingFloor> floorList;
    String parkingLotId;
    int totalfloors, slotsPerFloor;

    public ParkingLot(String parkingLotId, int totalfloors, int slotsPerFloor){
        if(totalfloors<0 || slotsPerFloor<0){
            System.out.println("INVALID FLOOR/SLOTS NUMBER");
            return;
        }
        this.totalfloors = totalfloors;
        this.slotsPerFloor = slotsPerFloor;
        this.parkingLotId = parkingLotId;
        this.floorList = new ArrayList<>();
        for(int i=0; i<totalfloors+1; i++){
            floorList.add(new ParkingFloor(slotsPerFloor));
        }

        System.out.println("Created Parking Lot("+parkingLotId+") with "+totalfloors+"floors and "+slotsPerFloor+" slots per floor.");
    }

    void park(VechicleType TYPE, String regNo, String color){

        for(int i=1; i<floorList.size(); i++){
            ParkingFloor floor = floorList.get(i);
            if(floor.isFloorFull(TYPE))
                continue; // we cannot accomodate that vechicle on this floor, check next floor
            // put the vechicle at lowest slot available
            List<Slot> slotList = floor.slotList;
            for(int j=1; j<slotsPerFloor+1; j++){
                    Slot slot = slotList.get(j);
                    if(slot.TYPE==TYPE && !slot.isOccupied){
                        // put the vechicle here
                        slot.park_vechicle(new Vechicle(TYPE, regNo, color)); // park the vechicle and get ticket
                        Ticket ticket = new Ticket();
                        String strTicket = ticket.createTicket(parkingLotId, i, j);
                        System.out.println("Parked vechicle. Ticket ID: "+strTicket);
                        return;
                    }
                }
        }
        // if all floors are full there is no available slots
        System.out.println("Parking Lot Full");
    }

    public boolean isTicketValid(String strTicket){
        // ticket schema -> <ticketId>_<PARKINGLOTID>_<FloorNo>_<SLotNo>
        String[] ticket = strTicket.split("_");
        int floorNo = Integer.parseInt(ticket[2]);
        int slotNo = Integer.parseInt(ticket[3]);
        // first check if it is occupied or not
        if((floorNo<1 || floorNo>totalfloors) || (slotNo<1 || slotNo>slotsPerFloor)){
            return false;
        }
        ParkingFloor floor = floorList.get(floorNo);
        Slot slot = floor.slotList.get(slotNo);
        //checking test cases
        return slot.isOccupied;
    }

    void unpark(String strTicket){
        //unpark_vehicle <ticket-id>_PR1234_2_5
        //check ticket is valid or not
        if(!isTicketValid(strTicket)){
            System.out.println("Invalid Ticket");
            return;
        }
        String[] ticket = strTicket.split("_");
        int floorNo = Integer.parseInt(ticket[2]);
        int slotNo = Integer.parseInt(ticket[3]);
        ParkingFloor floor = floorList.get(floorNo);
        Slot slot = floor.slotList.get(slotNo);
        Vechicle vechicle = slot.getVechicle();
        slot.unpark_vechicle(); // isOcuupied = false, vechicle = null;
        System.out.println("Unparked vechicle with Registration Number: "+vechicle.regNo+" and Color: "+vechicle.color);
    }

    public void display(){

    }

}
