package ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class Display {
    ParkingLot parkingLot;

    public Display(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    public List<Integer> displayFree(int floorNo, VechicleType TYPE){
        ParkingFloor floor = parkingLot.floorList.get(floorNo); // ist indexed
        if(floor.isFloorFull(TYPE)){
            return new ArrayList<>();
        }
        // display free slots for the same
        List<Slot> slotList = floor.slotList;
        List<Integer> free = new ArrayList<>();
        for(int i=0; i<parkingLot.slotsPerFloor; i++){
            Slot slot = slotList.get(i);
            if(slot.TYPE==TYPE && !slot.isOccupied){
                free.add(i);
            }
        }
        return free;
    }
    public List<Integer> displayOccupied(int floorNo, VechicleType TYPE){
        List<Slot> slotList = parkingLot.floorList.get(floorNo-1).slotList;
        List<Integer> occu = new ArrayList<>();
        for(int i=0; i<parkingLot.slotsPerFloor; i++){
            Slot slot = slotList.get(i);
            if(slot.TYPE==TYPE && slot.isOccupied){
                occu.add(i);
            }
        }
        return occu;
    }

    public int countFree(int floorNo, VechicleType TYPE){
        int count=0;
        ParkingFloor floor = parkingLot.floorList.get(floorNo-1);
        if(floor.isFloorFull(TYPE)){
            return 0;
        }
        List<Slot> slotList = floor.slotList;
        int free = 0;
        for(int i=0; i<parkingLot.slotsPerFloor; i++){
            Slot slot = slotList.get(i);
            if(slot.TYPE==TYPE && !slot.isOccupied){
                free++;
            }
        }
        return free;
    }
}
