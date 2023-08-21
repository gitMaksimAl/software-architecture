package Homework_3.Chassis;


public abstract class RotatedParts {
    
    protected float _multiplier;
    protected float rpm;

    public RotatedParts(float multiplier) {
        this._multiplier = multiplier;
        this.rpm = 0f;
    }
}
