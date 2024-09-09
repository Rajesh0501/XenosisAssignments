package XenosisThirdWeekAssignment;

class Vehicle {
    public void start() {
        System.out.println("Vehicle is starting. ");
    }
}
class Car extends Vehicle {
    @Override
    public void start() {
        System.out.println("Car is starting. ");
    }
}

class Bike extends Vehicle {
    @Override
    public void start() {
        System.out.println("Bike is starting. ");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle myVehicle  = new Vehicle();

        myVehicle = new Car();
        myVehicle.start();

        myVehicle = new Bike();
        myVehicle.start();
    }
}
