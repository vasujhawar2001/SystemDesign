package GymManagement;

public class Person {
    String id;
    String name;
    String email;
    String phone;
    String password;

    public Person(String name, String email, String phone, String password){
        this.name = name;
        this.password = password;;
        this.email = email;
        this.phone = phone;
        this.id = name+"_"+email;
    }
}
