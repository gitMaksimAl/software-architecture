package Lesson_2;

public abstract class ItemFabric {
    public abstract IGameItem createItem();

    public void openReward() {
        IGameItem gameItem = createItem();
        gameItem.open();
    }
}
