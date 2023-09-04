package Homework_3;
public class Main {
    public static void main(String[] args) {
        CarBuilder builder = new CarBuilder();
        Car carOne = builder.getPickUp();
        carOne.getInfo();
        // turn on dippedLight
        carOne.turnLight();
        // open door
        carOne.checkDoor(2);
        // open window
        carOne.checkWindow(0);
        System.out.println("||||||||||||||");
        carOne.getInfo();

        System.out.println("_____________");
        Car carTwo = builder.getSedan();
        carTwo.getInfo();
        // turn on dippedLight
        carTwo.turnLight();
        // open door
        carTwo.checkDoor(2);
        // open window
        carTwo.checkWindow(0);
        System.out.println("||||||||||||||");
        carTwo.getInfo();
    }
}
