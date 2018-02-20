package vehicle.model;

import vehicle.controller.Car;

public interface Actuator {

    /**
     * DESCRIPTION:
     * Name - moveVehicle
     * Input Argument Types - Car car, int distance
     * Output Return Types - int
     *
     * PRE-CONDITION: Passed Car object is initialized
     *                The value of the y-axis must be less than or equal to 95
     *
     * POST-CONDITION: Returns an int indicating the y-coordinate of the Car
     *
     *
     **/

    int moveVehicle(Car car, int distance);
}