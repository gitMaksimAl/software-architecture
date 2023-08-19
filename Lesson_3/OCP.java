package Lesson_3;

public class OCP {
    public class Vehicle {
        private int MaxSpeed;
        private String Type;

        public Vehicle(int speed, String type) {
            this.MaxSpeed = speed;
            this.Type = type;
        }

        public int getMaxSpeed() {
            return MaxSpeed;
        }

        public String getType() {
            return Type;
        }

        public double speedCalculate(Vehicle vehicle) {
            return this.getMaxSpeed();
        }
    }


    public class Car extends Vehicle {

        public Car(int speed, String type) {
            super(speed, type);
        }
    
        public double speedCalculate() {
            return getMaxSpeed() * 0.8;
        }
    }

    public class Bus extends Vehicle {

        public Bus(int speed, String type) {
            super(speed, type);
        }
    
        public double speedCalculate() {
            return getMaxSpeed() * 0.6;
        }
    }
}
