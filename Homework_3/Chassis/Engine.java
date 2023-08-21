package Homework_3.Chassis;


import Homework_3.Car.Status;
import Homework_3.Services.ISpin;

public abstract class Engine extends RotatedParts implements ISpin{
    protected Status status;

    public Engine(float multiplier) {
        super(multiplier);
        this.status = Status.Off;
    }

    @Override
    public String toString() {
        return String.format("ratio - %.2f, rpm - %.2f %s",
            this._multiplier,
            this.rpm,
            this.status.toString()
        );
    }
}
