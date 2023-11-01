package GymManagement;

import java.time.LocalDate;

public class Booking {
    Center center;
    Slot slot;
    User user;

    String bookingId;
    LocalDate date;
    public Booking(User user, Center center, Slot slot, LocalDate date){
        this.center = center;
        this.slot = slot;
        this.date = date;
        this.user = user;
        bookingId = user.id+" "+center.centerName+" "+slot.id;
    }
}
