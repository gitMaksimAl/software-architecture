package Homework_2.AnimalBox;

public class Dog extends Animal{

    @Override
    String getSound() {
        return "Woof, woof";
    }

    @Override
    void Move() {
        System.out.println(String.format("%s runs.", this.Name));
    }

    public Dog(String name, float health, float weight) {
        this.Name = name;
        this.Health = health;
        this.Weight = weight;
    }

    @Override
    public String toString() {
        return String.format("Dog: name = %s, health = %f, weight = %f",
            this.Name, this.Health, this.Weight);
    }
    
}
