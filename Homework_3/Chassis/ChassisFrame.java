package Homework_3.Chassis;


public class ChassisFrame {
    private int axleCount = 2;
    private int wheelCount = 4;
    private Axle[] _axles;
    private Engine _engine;
    private Transmission _gear;
    private Wheel[] _wheels;
    
    public ChassisFrame(Engine engine, Transmission gear) {
        this._axles = new Axle[2];
        this._engine = engine;
        this._gear = gear;
        this._wheels = new Wheel[4];
    }

    public void setWheel(int n, Wheel wheel) {
        this._wheels[n] = wheel;
    }

    public void setAxle(int n, Axle axle) {
        this._axles[n] = axle;
    }

    public void setAxleCount(int axleCount) {
        this.axleCount = axleCount;
    }

    public int getAxleCount() {
        return axleCount;
    }

    public void setWheelCount(int wheelCount) {
        this.wheelCount = wheelCount;
    }

    public int getWheelCount() {
        return wheelCount;
    }

    public void getInfo() {
        System.out.println(String.format("Chassis: engine:\n\t%s\ngear:\n\t%s",
            this._engine,
            this._gear));
        for (int i = 0; i < this._axles.length; i++) {
            System.out.println(this._axles[i]);
        }
        for (int i = 0; i < this._wheels.length; i++) {
            System.out.println(this._wheels[i]);
        }
    }
}
