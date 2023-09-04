package Homework_3.Body;

import Homework_3.Car.State;
import Homework_3.Services.ISwitch;

public class Window extends Glass implements ISwitch{
    private State _state;

    @Override
    public void toggle() {
        if (this._state == State.Closed) this._state = State.Open;
        else this._state = State.Closed;
    }

    public Window(float width, float hight) {
        super(width, hight);
        this._state = State.Closed;
    }

    @Override
    public String toString() {
        return String.format("Window: %.2fx%.2f\t%s",
            this.Hight, this.Hight, this._state.toString());
    }
}
