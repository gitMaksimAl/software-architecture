package Homework_3.Body;

import Homework_3.Car.Color;

public class Pickup extends BodyFrame {

    public Pickup(float width, float hight, Color color) {
        this.doorCount = 2;
        this._color = color;
        this._doors = new Door[this.doorCount];
        this._glases = new Glass[2];
        this._light = new HeadLight[2];
    }

    @Override
    public void checkDoor(int n) {
        if (n >= 0 && n < 2) this._doors[n].toggle();
    }

    @Override
    public void checkWindow(int n) {
        if (n >= 0 && n < 2) this._doors[n].checkWindow();
    }
}
