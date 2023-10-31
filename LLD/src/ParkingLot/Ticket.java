package ParkingLot;

public class Ticket {
    int ticketId=100;
    String ticket;

    public Ticket(){
        ticketId++;
    }

    public String createTicket(String parkingLotId, int floorNo, int slotNo){
        return ticketId+"_"+parkingLotId+"_"+floorNo+"_"+slotNo;
    }

}
