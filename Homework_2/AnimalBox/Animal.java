package Homework_2.AnimalBox;

public abstract class Animal {
    protected float Health;
    protected float Weight;
    protected String Name;

    abstract String getSound();
    abstract void Move();
    protected void eat(Animal some) {
        if ((some.Weight > 0f)
            && (some.Weight <= this.Weight / 2f)) {
            some.Health = 0f;
            some.Weight *= 0.3f;
            this.Weight *= 1.2f;
            this.Health *= 1.1f;
        }
    }
}
