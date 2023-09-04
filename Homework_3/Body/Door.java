package Homework_3.Body;


import Homework_3.Car.State;
import Homework_3.Services.ISwitch;

public class Door implements ISwitch{
    private Window _window;
    private State _state;

    public Door(Window window) {
        this._window = window;
        this._state = State.Closed;
    }

    @Override
    public void toggle() {
        if (this._state == State.Closed) this._state = State.Open;
        else this._state = State.Closed;
    }

    public void checkWindow() {
        this._window.toggle();
    }

    @Override
    public String toString() {
        return String.format("Door: %s, window - %s",
            this._state.toString(), this._window);
    }
}
