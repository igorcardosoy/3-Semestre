package model.entity.persons;

public class Escort {
    String name;
    int age;

    public Escort(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
