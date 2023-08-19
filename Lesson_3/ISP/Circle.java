package Lesson_3.ISP;


/**
 * Circle
 */
public class Circle implements IShape {

    private double Radius;

    public Circle(float radius) {
        this.Radius = radius;
    }

    @Override
    public double area() {
        return 2 * 3.14 * this.Radius;
    }
    
    public double getRadius() {
        return Radius;
    }

    public void setRadius(double radius) {
        Radius = radius;
    }
}
