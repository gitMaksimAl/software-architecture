package Lesson_3.DIP;

public class Car {
    private Engine Motor;

    public Car(PetrolEngine engine) {
        this.Motor = engine;
    }

    public void PetrolEngineStart() {}
}
