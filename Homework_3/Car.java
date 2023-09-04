package Homework_3;

import Homework_3.Body.BodyFrame;
import Homework_3.Chassis.ChassisFrame;

public class Car {
    
    public enum Status {On, Off};
    public enum State {Open, Closed}
    public enum Color {Black, White, Red, Green, Blue, Gray}

    private ChassisFrame _chassis;
    private BodyFrame _body;
    public Car(ChassisFrame chassis, BodyFrame body) {
        this._chassis = chassis;
        this._body = body;
    }

    protected void checkWindow(int num) {
        this._body.checkWindow(num);
    }

    protected void turnLight() {
        this._body.turnLight();
    }

    public void checkDoor(int n) {
        this._body.checkDoor(n);
    }

    public void getInfo() {
        this._body.getInfo();
        this._chassis.getInfo();
    }
}
