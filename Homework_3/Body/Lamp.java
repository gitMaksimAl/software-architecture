package Homework_3.Body;

import Homework_3.Car.Status;
import Homework_3.Services.ISwitch;

public class Lamp implements ISwitch{

    public enum Type {Xenon, Halogen, LED};

    private Type _type;
    public Status _status;

    public Lamp(Type type) {
        this._type = type;
        this._status = Status.Off;
    }

    @Override
    public void toggle() {
        if (this._status == Status.Off) this._status = Status.On;
        else this._status = Status.Off;
    }

    @Override
    public String toString() {
        return String.format("Type - %s, %s",
            this._type.toString(),
            this._status.toString()
        );
    }
}
