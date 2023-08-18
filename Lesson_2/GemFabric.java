package Lesson_2;

public class GemFabric extends ItemFabric {

    @Override
    public IGameItem createItem() {
        return new GemReward();
    }
    
}
