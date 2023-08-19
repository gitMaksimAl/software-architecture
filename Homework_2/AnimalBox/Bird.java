package Homework_2.AnimalBox;

public class Bird extends Animal{

    @Override
    String getSound() {
        return "Chirps, chirps.";
    }

    @Override
    void Move() {
        System.out.println(String.format("%s fly.", this.Name));
    }
    
    @Override
    public String toString() {
        return String.format("Bird: name = %s, health = %f, weight = %f",
            this.Name, this.Health, this.Weight);
    }

    public Bird(String name, float health, float weight) {
        this.Name = name;
        this.Health = health;
        this.Weight = weight;
    }
}
