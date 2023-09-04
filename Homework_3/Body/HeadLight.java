package Homework_3.Body;

import Homework_3.Car.Status;
import Homework_3.Services.ISwitch;

public class HeadLight implements ISwitch{
    private Lamp DippedBeam;
    private Lamp HighBeam;

    public HeadLight(Lamp dipped, Lamp high) {
        this.DippedBeam = dipped;
        this.HighBeam = high;
    }

    @Override
    public void toggle() {
        if (this.DippedBeam._status == Status.On) {
            this.DippedBeam.toggle();
            this.HighBeam.toggle();
        } else if (this.HighBeam._status == Status.On) {
            this.HighBeam.toggle();
            this.DippedBeam.toggle();
        } else this.DippedBeam.toggle();
    }

    @Override
    public String toString() {
        return String.format("Dipped - %s, high - %s",
                this.DippedBeam,
                this.HighBeam);
    }
}
