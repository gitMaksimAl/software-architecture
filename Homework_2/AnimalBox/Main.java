package Homework_2.AnimalBox;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        AnimalFabric zooFabric = new DogFabric();
        AnimalFabric zooFabric2 = new BirdFabric();
        
        // create some animals
        System.out.println("Create animals....");
        List<Animal> animalBox = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            animalBox.add(zooFabric.getOne());
            Thread.sleep(2005);
            animalBox.add(zooFabric2.getOne());
        }

        // action simulation
        Iterator<Animal> it = animalBox.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
