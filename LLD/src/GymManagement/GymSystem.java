package GymManagement;

import ObserverPattern.Observable.StockObservable;

import java.awt.print.Book;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GymSystem {
    //this should be a singleton class
    private static GymSystem system = null;
    Map<Integer, Center> centerList; // centerid, center
    Map<String, User> userMap;
    private GymSystem(){
        centerList = new HashMap<>();
        userMap = new HashMap<>();
        addCenter();
    };
    public static GymSystem getInstance(){
        if(system==null){
            system = new GymSystem();
        }
        return system;
    }

    public void addCenter(){
        centerList.put(1, new Center(1, "Kormangla"));
        centerList.put(2, new Center(2, "Belandur"));
    }

    public String registerUser(String name, String email, String phone, String password){
        User user = new User(name, email, phone, password);
        userMap.put(user.id, user);
        return user.id;
    }

// viewWorkoutsForDay(2020-03-30)
    public void viewWorkoutsforDay(String date){
        // LocalDate d1 = LocalDate.parse(dInStr);
        LocalDate d1 = LocalDate.parse(date);
        // now we will fetch all workouts from each center
        for(Map.Entry<Integer, Center> mapEntry : centerList.entrySet()){
            Center center = mapEntry.getValue();
            Map<LocalDate, Map<Integer, Slot>> map = center.workoutsEachDay;
            Map<Integer, Slot> slots = map.get(d1);

            for(Map.Entry<Integer,Slot> slotEntry : slots.entrySet()){
                Slot slot = slotEntry.getValue();
                /*
                    Center ID: 1
                    Center Name: Kormangla
                    Slot ID: 1
                    Slot Timing: 06 AM - 07 AM
                    Workout type: Weights
                    Slot capacity: 2
                 */
                System.out.println("Center ID: "+center.centerId);
                System.out.println("Center Name: "+center.centerName);
                System.out.println("Slot ID: "+slot.id);
                System.out.println("Slot Timing: "+slot.duration);
                System.out.println("Workout Type: "+slot.type);
                System.out.println("Slot Capacity: "+slot.getCapacity());
                System.out.println("***********************");
            }
        }
    }

    //bookWorkout(aash123, 1, 1, 2020-03-12)
    //User ID, Center ID, Slot ID, Day
    public String bookWorkout(String userId, int centerId, int slotId, String date){
        User user = userMap.get(userId);
        if(user==null)  return "CREATE USER FIRST, NO USER FOUND!";

        //get slot and center
        Center center = centerList.get(centerId);
        if(center==null)    return "NO CENTER FOUND!, CHECK CENTER ID!";

        Map<LocalDate, Map<Integer, Slot>> map = center.workoutsEachDay;
        LocalDate d1 = LocalDate.parse(date);
        Map<Integer, Slot> slots = map.get(d1);

        Slot slot = slots.get(slotId);
        if(slot==null)    return "NO SLOT FOUND!, CHECK SLOT ID!";

        //check if user already booked the same slot
        for (Booking booking : user.bookingList) {
            if(booking.bookingId.equals(user.id+" "+center.centerName+" "+slot.id)){
                return "SLOT ALREADY BOOKED!";
            }
        }

        // booking logic for slots
        if(slot.getCapacity()<1){
            return "SLOT FULL, BOOK ANOTHER!";
        }
        else{
            slot.setCapacity(slot.getCapacity()-1);
        }
        // create booking
        Booking booking = new Booking(user, center, slot, d1);
        //ADD BOOKING TO USER
        user.addBooking(booking);
        System.out.println("BOOKED SLOT!");
        return booking.bookingId;
    }

    //viewUserPlan(aash123, 20-03-12)
    public void viewUserPlan(String userId, String date){
        User user = userMap.get(userId);
        if(user==null) {
            System.out.println("CREATE USER FIRST, NO USER FOUND!");
            return;
        }
        for (Booking booking : user.bookingList) {

            if(booking.date.equals(LocalDate.parse(date))){
                System.out.println("USER PLAN FOR "+date);
                System.out.println("User Name: "+user.name);
                System.out.println("Center Name: "+booking.center.centerName);
                System.out.println("Slot Timing: "+booking.slot.duration);
                System.out.println("Workout Type: "+ booking.slot.type);
                return;
            }
        }
        System.out.println("NO PLANS!");
    }

}
