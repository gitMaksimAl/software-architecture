package Homework_2;

public class BoyFabric extends SurpriseFabric{

    @Override
    CabbagePatch getCabbage() {
       return new BoyPath();
    }
    
}
