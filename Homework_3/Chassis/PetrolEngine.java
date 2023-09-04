package Homework_3.Chassis;

public class PetrolEngine extends Engine{
    private String powerSupply;

    public PetrolEngine(float multiplier) {
        super(multiplier);
        this.powerSupply = "Gas";
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
    
}
