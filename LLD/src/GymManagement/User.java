package GymManagement;

import java.util.ArrayList;
import java.util.List;

public class User extends  Person{

    List<Booking> bookingList;
    public User(String name, String email, String phone, String password){
        super(name, email, phone, password);
        this.bookingList = new ArrayList<>();
    }

    public void addBooking(Booking booking){
        bookingList.add(booking);
    }
}
