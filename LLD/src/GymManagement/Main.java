package GymManagement;

import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println(LocalDate.now());
        System.out.println("USE DATE FORMAT->  2023-11-02 ");
        GymSystem system = GymSystem.getInstance();
        // registerUser(“Aashi”, “abc@gmail.com”, “123”,”xyz”)
        System.out.println(system.registerUser("Aashi", "abc@gmail.com", "123","xyz"));
        System.out.println("***************************");
        System.out.println("View workouts of the day: ");
        system.viewWorkoutsforDay("2023-11-02");
        System.out.println(system.bookWorkout("Aashi_abc@gmail.com", 1,3,"2023-11-02"));
        System.out.println("***********************");
        system.viewUserPlan("Aashi_abc@gmail.com", "2023-11-02");
        System.out.println("*************************");
        System.out.println(system.bookWorkout("Aashi_abc@gmail.com", 1,3,"2023-11-02"));
        System.out.println("*************************");
        // CHECK SLOT CAPACITY FOR THE SAME SLOT IT DECREASES BY ONE
//        System.out.println("View workouts of the day: ");
//        system.viewWorkoutsforDay("2023-11-02");
    }
}
