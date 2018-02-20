package tests;

import org.junit.Before;
import org.junit.Test;
import vehicle.controller.Car;
import vehicle.controller.MockActuator;

import static org.junit.Assert.assertEquals;

public class CarScenarios {
    private Car car;
    private MockActuator actuator;


    @Before
    public void setUp() {
        actuator = new MockActuator();
        car = new Car(actuator);
    }

    @Test
    public void startAtBeginningOfStreetChangeLaneThenContinueTest() {
        Car testCar = new Car(10, 10, 10, 10, actuator);
        testCar.setCarCoordinates(15, 0);
        assertEquals(5, testCar.moveForward());
        assertEquals(10, testCar.moveForward());
        assertEquals(15, testCar.moveForward());

        assertEquals("Lane successfully changed", testCar.changeLane());
        assertEquals(10, testCar.xPos);

        while (testCar.yPos < 100) {
            testCar.moveForward();
        }

        assertEquals(100, testCar.yPos);

    }

    @Test
    public void startAtBeginningOfStreetCarDetectThenContinueTest() {
        Car testCar = new Car(5, 5, 10, 10, actuator);
        testCar.setCarCoordinates(15, 0);
        assertEquals(5, testCar.moveForward());
        assertEquals(10, testCar.moveForward());
        assertEquals(15, testCar.moveForward());

        assertEquals("Lane could not be changed", testCar.changeLane());
        assertEquals(15, testCar.xPos);

        while (testCar.yPos < 100) {
            testCar.moveForward();
        }

        assertEquals(100, testCar.yPos);
    }

    @Test
    public void startAtBeginningOfStreetThreeBadValuesThenContinueTest() {
        Car testCar = new Car(64, 5, -3, 53, actuator);
        testCar.setCarCoordinates(15, 0);
        assertEquals(5, testCar.moveForward());
        assertEquals(10, testCar.moveForward());
        assertEquals(15, testCar.moveForward());

        assertEquals("Error: Values not reliable.", testCar.leftLaneDetect(2));
        assertEquals(15, testCar.xPos);

        while (testCar.yPos < 100) {
            testCar.moveForward();
        }

        assertEquals(100, testCar.yPos);
    }
}