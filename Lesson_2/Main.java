package Lesson_2;

public class Main {
    public static void main(String[] args) {
        ItemFabric fabric = new GoldFabric();
        fabric.openReward();
        fabric = new GemFabric();
        fabric.openReward();
    }
    
}
