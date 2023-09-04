package Homework_3.Body;

public class Glass {

    protected float Width;
    protected float Hight;

    public Glass(float width, float hight) {
        this.Width = width;
        this.Hight = hight;
    }

    @Override
    public String toString() {
        return String.format("Window: %.2fx%.2f", this.Width, this.Hight);
    }
}
