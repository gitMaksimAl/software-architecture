package Homework_3.Body;

import Homework_3.Car.Color;

public abstract class BodyFrame {
    
    protected float _width;
    protected float _hight;
    protected int doorCount;
    protected Color _color;
    protected Door[] _doors;
    protected Glass[] _glases;
    protected HeadLight[] _light;

    public void checkWindow(int num) {
        this._doors[num].checkWindow();
    }

    public void checkDoor(int num) {
        this._doors[num].toggle();
    }

    public void turnLight() {
        for (int i = 0; i < this._light.length; i++) {
            this._light[i].toggle();
        }
    }

    public void setDoor(int n, Door door) {
            this._doors[n] = door;
    }

    public void setGlass(int n, Glass glasses) {
        this._glases[n] = glasses;
    }

    public int getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }

    public HeadLight[] get_light() {
        return _light;
    }

    public Door[] get_doors() {
        return _doors;
    }

    private void doorInfo() {
        for (int i = 0; i < this.doorCount; i++) {
            System.out.println(this._doors[i]);
        }
    }

    private void windowInfo() {
        for (int i = 0; i < this._glases.length; i++) {
            System.out.println(this._glases[i]);
        }
    }

    private void lightInfo() {
        for (int i = 0; i < this._light.length; i++) {
            System.out.println(this._light[i]);
        }
    }

    public void getInfo() {
        System.out.println(String.format("Body:\nColor - %s",
            this._color.toString()));
        doorInfo();
        windowInfo();
        lightInfo();
    }
}
