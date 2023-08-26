package Lesson_2;

public class GoldFabric extends ItemFabric {

    @Override
    public IGameItem createItem() {
        return new GoldReward();
    }
    
}
