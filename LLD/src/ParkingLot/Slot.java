package ParkingLot;

public class Slot {
    VechicleType TYPE;
    boolean isOccupied=false;
    Vechicle vechicle;
    public Slot(VechicleType TYPE){
        this.TYPE = TYPE;
    }

    public void park_vechicle(Vechicle vechicle){
        isOccupied = true;
        this.vechicle = vechicle;
    }

    public void unpark_vechicle(){
        isOccupied = false;
        this.vechicle = null;
    }

    public Vechicle getVechicle(){
        return  this.vechicle;
    }

}
