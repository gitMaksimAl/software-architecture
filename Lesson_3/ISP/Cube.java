package Lesson_3.ISP;

/**
 * Cube
 */
public class Cube implements IShape, I3DShape {
    
    private int Width;

    public Cube(int width) {
        this.Width = width;
    }

    @Override
    public double area() {
        return this.Width * this.Width * 6;
    }

    @Override
    public double value() {
        return this.Width * this.Width * this.Width;
    }

    public int getWidth() {
        return Width;
    }

    public void setWidth(int width) {
        Width = width;
    }
}
