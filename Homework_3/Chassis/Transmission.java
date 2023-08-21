package Homework_3.Chassis;

import Homework_3.Services.ISpin;

public class Transmission extends RotatedParts implements ISpin{

    public Transmission(float multiplier) {
        super(multiplier);
    }


    @Override
    public void spin() {
        this.rpm *= this._multiplier;
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
        return String.format("ratio - %.2f, rpm - %.2f",
            this._multiplier,
            this.rpm
        );
    }
}
