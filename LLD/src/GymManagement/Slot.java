package GymManagement;

public class Slot {
    int maxCapacity = 3;
    WORKOUT_TYPE type;
    String duration;
    int id;
    private int capacity;

    public Slot(int id, WORKOUT_TYPE type, String duration){
        this.id = id;
        this.type = type;
        this.duration = duration;
        this.capacity = maxCapacity;
    }

    public void setCapacity(int newCapacity){
        this.capacity = newCapacity;
    }
    public int getCapacity(){
        return capacity;
    }
}
