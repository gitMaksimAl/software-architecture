package Homework_3.Chassis;

import Homework_3.Services.ISpin;

public class Wheel extends RotatedParts implements ISpin {

    private int Radius;

    @Override
    public void spin() {
        this.rpm *= this._multiplier;
    }

    public Wheel(int radius, float multiplier) {
        super( multiplier);
        this.Radius = radius;
    }

    @Override
    public void stop() {
        this.rpm /= this._multiplier;
    }

    @Override
    public float get_rpm() {
        return this.rpm;
    }

    @Override
    public String toString() {
        return String.format("Wheel: ratio - %.2f, rpm - %.2f, radius - %d",
            this._multiplier,
            this.rpm,
            this.Radius
        );
    }
}
