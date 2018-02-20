package vehicle.controller;

import vehicle.model.Actuator;

public class MockActuator implements Actuator {

    @Override
    public int moveVehicle(Car car, int distance) {
        if (car.yPos > 95) {
            return 1;
        } else {
            car.yPos += distance;
        }
        return car.yPos;
    }
}