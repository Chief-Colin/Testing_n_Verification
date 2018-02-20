package tests;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import vehicle.model.*;
import vehicle.controller.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CarTests {
    private Car car;

    @Before
    public void setUp() {
        car = new Car();
    }


    //TC 1
    @Test
    public void moveForwardTest() {
        car.yPos = 95;
        car.xPos = 0;
        car.moveForward();
        Assert.assertEquals(1, car.moveForward());
    }

    //TC 2
    @Test
    public void moveForwardTest2() {
        car.xPos = 0;
        car.yPos = 0;
        Assert.assertEquals(5, car.moveForward());
    }

    //    //TC 3
    @Test
    public void moveForwardTest3() {
        car.xPos = 0;
        car.yPos = 100;
        Assert.assertEquals(1, car.moveForward());
    }

    //    //TC 4
    @Test
    public void moveForwardTest4() {
        car.xPos = 0;
        car.yPos = 55;
        Assert.assertEquals(60, car.moveForward());
    }

    //TC 5
    @Test
    public void whereIsTest() {
        int xPos = 15;
        int yPos = 100;
        car.setCarCoordinates(xPos, yPos);
        int[] whereIsCar = car.whereIs();

        assertEquals(whereIsCar[0], 15);
        assertEquals(whereIsCar[1], 100);
    }


    // TC 6
    @Test
    public void whereIsBadValuesTest() {

        //first set correct values, then bad ones
        //->test that good values stay x and y.
        car.setCarCoordinates(20, 30);

        car.setCarCoordinates(6, 5);
        int[] carPos = car.whereIs();

        assertEquals(carPos[0], 20);
        assertEquals(carPos[1], 30);

    }

    //    //TC 7
    @Test
    public void whereIsBadXYValueTest() {
        //tries to set one bad x value, then one bad y value
        //-> test should not let set the bad values.
        car.setCarCoordinates(0, 100);
        car.setCarCoordinates(100, 0);
        int[] carPos = car.whereIs();


        assertEquals(carPos[0], 0);
        assertEquals(carPos[1], 0);
    }
//    //TC 8
//    @Test
//    public void whereIsEdgeValuesTest() {
//        int xPos = 15;
//        int yPos = 100;
//        int[] coordinates = car.whereIs();
//
//        assertEquals(new int[] {xPos, yPos}, car.whereIs());
//
//    }
//    //TC 10
//    @Test
//    public void whereIsBadValuesTest() {
//        int xPos = 2;
//        int yPos = 2;
//        int[] coordinates = car.whereIs();
//
//        assertEquals("Car is out of bounds", car.whereIs();
//
//    }

    //TC 11 - Car  detection with one faulty sensor
    @Test
    public void oneFaultySensorValueCarDetectedTest() {
        Car testCar = new Car(-1, 5, 5, 10);

        assertEquals("Warning: Car detected.", testCar.leftLaneDetect(2));
    }

    //TC 12 - Car detection with two faulty sensors
    @Test
    public void twoFaultySensorValuesCarDetectedTest() {
        Car testCar = new Car(-1, -1, 5, 10);

        assertEquals("Warning: Car detected.", testCar.leftLaneDetect(2));
    }

    //TC 13 - Car detection with three faulty sensors, should return error message indicating unreliable sensor values
    @Test
    public void threeFaultySensorValuesCarDetectedTest() {
        Car testCar = new Car(-1, -1, 5, -1);

        assertEquals("Error: Values not reliable.", testCar.leftLaneDetect(2));
    }

    //TC 14 - Car detection with no faulty sensor values
    @Test
    public void carDetectedInLeftLaneTest() {
        Car testCar = new Car(10, 10, 5, 2);

        assertEquals("Warning: Car detected.", testCar.leftLaneDetect(2));
    }

    //TC 15 - Empty lane detection with no faulty sensor values
    @Test
    public void emptyLeftLaneDetectTest() {
        Car testCar = new Car(10, 10, 50, 50);

        assertEquals("No car detected on the left lane.", testCar.leftLaneDetect(2));
    }

    //TC 16
    @Test
    public void carChangeLaneTestRightmostLaneBeginningOfStreet() {
        Car testCar = new Car(10, 10, 10, 10);
        testCar.setCarCoordinates(15, 0);

        assertEquals("Lane successfully changed", testCar.changeLane());
    }

    //TC 17
    @Test
    public void carChangeLaneTestMiddleLaneMidWayOfStreet() {
        Car testCar = new Car(10, 10, 10, 10);
        testCar.setCarCoordinates(10, 50);
        assertEquals("Lane successfully changed", testCar.changeLane());
    }

    //TC 18
    @Test
    public void carCannotChangeLaneTestLeftmostLaneBeginningOfStreet() {
        Car testCar = new Car(10, 10, 10, 10);
        testCar.setCarCoordinates(5, 0);
        assertEquals("Lane successfully changed", testCar.changeLane());
    }

    //TC 19
    @Test
    public void carCannotChangeLaneTestRightmostLaneEndOfStreet() {
        Car testCar = new Car(10, 10, 10, 10);
        testCar.setCarCoordinates(15, 96);
        assertEquals("Lane could not be changed", testCar.changeLane());
    }

    //TC 20 - Checks whether or not the sensor values inside leftLaneDetect() are queried twice to check for
    //        faulty sensor values.
    @Test
    public void queryCheckedTwiceTest() {
        Car carTest = new Car(-1, 10, 5, 50);
        carTest.leftLaneDetect(2);
        assertTrue(carTest.queryCheck);
    }

    //TC 21 - Checks if the queried sensor values are the twice in both queries
    @Test
    public void checkQueriedSensorValuesAreTheSameTest() {
        Car carTest = new Car(10, 5, 5, 10);
        carTest.leftLaneDetect(1);

        ArrayList<Radar> firstRadar = carTest.getRadars();
        Lidar firstLidar = carTest.getLidar();

        carTest.leftLaneDetect(1);

        ArrayList<Radar> secondRadar = carTest.getRadars();
        Lidar secondLidar = carTest.getLidar();

        assertTrue(firstLidar.equals(secondLidar));
        assertTrue(firstRadar.equals(secondRadar));

    }
}