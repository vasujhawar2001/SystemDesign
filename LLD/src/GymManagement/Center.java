package GymManagement;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class Center {
    Admin admin;
    int centerId;
    String centerName;

//    String dInStr = "2011-09-01";
//    LocalDate d1 = LocalDate.parse(dInStr);
    Map<LocalDate, Map<Integer, Slot>> workoutsEachDay;

    public Center(int id, String centerName){
        this.centerId = id;
        this.centerName = centerName;
        this.workoutsEachDay = new HashMap<>();
        initializeWorkouts(); // this function will put workout for a week, demo purpose
    }

    private void initializeWorkouts() {
        // initializing workouts
        // 6 slots in a day for next 2 days;
        LocalDate date = LocalDate.now();
        for(int i=0; i<2; i++){
            Map<Integer, Slot> slots = new HashMap<>();
            int slotId = 1;
            for(int j=0; j<TimeSlots.durations.length; j++){
                if(j%3==0)
                    slots.put(slotId, new Slot(slotId, WORKOUT_TYPE.CARDIO, TimeSlots.durations[j]));
                else
                    slots.put(slotId, new Slot(slotId, WORKOUT_TYPE.WEIGHT, TimeSlots.durations[j]));
                slotId++;
            }
            workoutsEachDay.put(date, slots);
            date = date.plusDays(1);
        }
    }

    // here admin can have crud optionality
    // for a particular day, if he/she wants to do changes to the slot or remove it
}
