package Homework_2.AnimalBox;

import java.time.Clock;

public class DogFabric implements AnimalFabric {
    private static final String[] DOG_NAMES = new String[] {
        "Sharik", "Bobik", "Druzhok", "Ataman", "Valet"
    };

    @Override
    public Animal getOne() {
        Dog dog = 
            new Dog(DOG_NAMES[(int)Clock.systemUTC().instant().toEpochMilli() % 5],
            100f,
            (float)(30 + ((int)Clock.systemUTC().instant().toEpochMilli()) % 50));
        System.out.println(dog.getSound());
        return dog;
    }
    
}
