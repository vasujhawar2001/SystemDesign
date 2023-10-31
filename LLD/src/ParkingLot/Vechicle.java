package ParkingLot;

public class Vechicle {
    VechicleType TYPE;
    String regNo;
    String color;

    public Vechicle(VechicleType TYPE, String regNo, String color){
        this.TYPE = TYPE;
        this.color = color;
        this.regNo = regNo;
    }
}
