package Homework_2.AnimalBox;

import java.time.Clock;

public class BirdFabric implements AnimalFabric {
    
    private static final String[] BIRD_NAMES = new String[] {
        "Chubakka", "Cosmos", "Serebrjanka", "Almaz", "Gljuk"
    };

    @Override
    public Animal getOne() {
        Animal bird = 
            new Bird(BIRD_NAMES[(int)Clock.systemUTC().instant().toEpochMilli() % 5],
            100f,
            (float)((int)Clock.systemUTC().instant().toEpochMilli() % 30));
        System.out.println(bird.getSound());
        return bird;
    }
}
