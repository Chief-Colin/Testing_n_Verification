package tests;

import org.junit.Before;
import org.junit.Test;
import vehicle.controller.Car;
import vehicle.controller.MockActuator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        testCar.setCarCoordinates(100,100);

        testCar.setCarCoordinates(15, 0);
        assertEquals(5, testCar.moveForward());
        assertEquals(10, testCar.moveForward());
        assertEquals(15, testCar.moveForward());

        testCar.setRadars(100, 100, 10);
        assertEquals("Lane successfully changed", testCar.changeLane());
        assertEquals(10, testCar.xPos);

        assertEquals(10, testCar.whereIs()[0]);
        assertEquals(20, testCar.whereIs()[1]);


        while (testCar.yPos < 100) {
            testCar.moveForward();
        }

        assertEquals(100, testCar.yPos);
        assertEquals(100, testCar.moveForward());
        testCar.setCarCoordinates(testCar.xPos, testCar.yPos + 5);
        assertEquals(100, testCar.yPos);
    }

    @Test
    public void startAtBeginningOfStreetCarDetectThenContinueTest() {
        Car testCar = new Car(10, 10, 10, 5, actuator);
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
        assertEquals(100, testCar.moveForward());

    }

    @Test
    public void startAtBeginningOfStreetThreeBadValuesThenContinueTest() {
        Car testCar = new Car(64, 5, -3, 53, actuator);
        testCar.setCarCoordinates(15, 0);
        assertEquals(5, testCar.moveForward());
        assertEquals(10, testCar.moveForward());
        assertEquals(15, testCar.moveForward());

        assertEquals("Error: Values not reliable.", testCar.leftLaneDetect(2));

        while (testCar.yPos < 100) {
            testCar.moveForward();
        }

        assertEquals(100, testCar.yPos);

    }

    @Test
    public void faultySensorsScenarioTest() {
        Car testCar = new Car(5, 10, 10, 5, actuator);
        testCar.setCarCoordinates(15, 0);
        assertEquals(5, testCar.moveForward());
        assertEquals(10, testCar.moveForward());
        assertEquals(15, testCar.moveForward());

        assertEquals("Warning: Car detected.", testCar.leftLaneDetect(2));

        int frontRadar = testCar.getRadars().get(0).getSensorValue();
        int midRadar = testCar.getRadars().get(1).getSensorValue();
        int backRadar = testCar.getRadars().get(2).getSensorValue();
        int lidar = testCar.getLidar().getSensorValue();

        testCar.moveForward();
        testCar.moveForward();
        testCar.moveForward();

        assertEquals("Warning: Car detected.", testCar.leftLaneDetect(1));

        testCar.setRadars(10, 10, 10);
        testCar.setLidar(10);

        int secondFrontRadar = testCar.getRadars().get(0).getSensorValue();
        int secondMidRadar = testCar.getRadars().get(1).getSensorValue();
        int secondBackRadar = testCar.getRadars().get(2).getSensorValue();
        int secondLidar = testCar.getLidar().getSensorValue();


        assertTrue(lidar != secondLidar);
        assertTrue(frontRadar != secondFrontRadar);
        assertTrue(midRadar == secondMidRadar);
        assertTrue(backRadar == secondBackRadar);


        assertEquals("No car detected on the left lane.", testCar.leftLaneDetect(1));
    }
}