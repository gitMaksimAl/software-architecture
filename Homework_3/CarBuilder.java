package Homework_3;

import Homework_3.Body.BodyFrame;
import Homework_3.Body.Door;
import Homework_3.Body.Glass;
import Homework_3.Body.HeadLight;
import Homework_3.Body.Window;
import Homework_3.Chassis.Axle;
import Homework_3.Chassis.ChassisFrame;
import Homework_3.Chassis.Engine;
import Homework_3.Chassis.PetrolEngine;
import Homework_3.Chassis.Transmission;
import Homework_3.Chassis.Wheel;
import Homework_3.Body.Lamp;
import Homework_3.Body.Pickup;
import Homework_3.Body.Sedan;
import Homework_3.Body.Lamp.Type;
import Homework_3.Car.Color;

public class CarBuilder {

    private float transmissionRatio = 3.07f;
    private float engineRatio = 11.3f;
    private float wheelRatio = 3.07f;
    private int wheelRadius = 17;
    private float axleRatio = 3.2f;
    private float doorGlassWidth = 20f;
    private float doorGlassHigh = 30f;
    private float WindShieldWidth = 1200f;
    private float WindShieldHigh = 500f;
    private float backGlassWidth = 900f;
    private float backGlassHigh = 500f;
    private float bodyWidth = 2000f;
    private float bodyHigh = 1500f;
    private Type diipedpType = Type.Halogen;
    private Type highType = Type.Xenon;
    private Color carColor = Color.Gray;
    private Engine engine;
    private Transmission gear;
    private BodyFrame body;
    private ChassisFrame chassis;
    private Car instance;

    Car getSedan() {
        this.body = new Sedan(this.bodyWidth, this.bodyHigh, this.carColor);
        makeHeadLight();
        makeDoors();
        makeGlasses();
        makeEngine();
        makeTransmission();
        this.chassis = new ChassisFrame(this.engine,
            this.gear);
        makeAxles();
        makeWheels();
        this.instance = new Car(this.chassis, this.body);
        return this.instance;
    }

    Car getPickUp() {
        this.body = new Pickup(this.bodyWidth, this.bodyHigh, this.carColor);
        makeHeadLight();
        makeDoors();
        makeGlasses();
        makeEngine();
        makeTransmission();
        this.chassis = new ChassisFrame(this.engine,
            this.gear);
        makeAxles();
        makeWheels();
        this.instance = new Car(this.chassis, this.body);
        return this.instance;
    }

    private void makeWheels() {
        for (int i = 0; i < this.chassis.getWheelCount(); i++) {
            this.chassis.setWheel(i,
                new Wheel(this.wheelRadius, this.wheelRatio));
        }
    }

    private void makeAxles() {
        this.chassis.setAxle(0, new Axle(this.axleRatio));
        this.chassis.setAxle(1, new Axle(this.axleRatio));
    }

    private void makeEngine() {
        this.engine = new PetrolEngine(this.engineRatio);
    }

    private void makeTransmission() {
        this.gear = new Transmission(this.transmissionRatio);
    }

    private void makeHeadLight() {
        this.body.get_light()[0] =
            new HeadLight(new Lamp(this.diipedpType), new Lamp(this.highType));
        this.body.get_light()[1] =
            new HeadLight(new Lamp(this.diipedpType), new Lamp(this.highType));
    }

    private void makeDoors() {
        for (int i = 0; i < this.body.getDoorCount(); i++) {
            this.body.setDoor(i,
                new Door(new Window(this.doorGlassWidth, this.doorGlassHigh)));
        }
    }

    private void makeGlasses() {
            this.body.setGlass(0,
                new Glass(this.WindShieldWidth, this.WindShieldHigh));
            this.body.setGlass(1,
                new Glass(this.backGlassWidth, this.backGlassHigh));
    }

    public void setTransmission(float ratio) {
        this.transmissionRatio = ratio;
    }

    public void setHeadLight(Type dippedType, Type highType) {
        this.diipedpType = dippedType;
        this.highType = highType;
    }

    public void setEngine(float ratio) {
        this.engineRatio = ratio;
    }

    public void setAxle(float ratio) {
        this.axleRatio = ratio;
        this.wheelRatio = ratio;
    }
}
