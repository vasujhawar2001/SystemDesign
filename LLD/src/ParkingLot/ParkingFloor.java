package ParkingLot;

import java.util.ArrayList;
import java.util.List;

import static ParkingLot.VechicleType.*;

public class ParkingFloor {

    List<Slot> slotList;
    boolean isFull = false;

    public ParkingFloor(int slotSize){
        this.slotList = new ArrayList<Slot>();
        //given in requirements
        for(int i=1; i<slotSize+1; i++){   // 1st indexed
            if(i==1){
                slotList.add(new Slot(TRUCK));
            }
            if(i<4){
                slotList.add(new Slot(BIKE));
            }
            slotList.add(new Slot(CAR));
        }
    }

    public boolean isFloorFull(VechicleType TYPE){
        for(int i=1; i<slotList.size(); i++){
            Slot slot = slotList.get(i);
            if(slot.TYPE==TYPE && !slot.isOccupied){
                return false;
            }
        }
        return true;
    }
}
