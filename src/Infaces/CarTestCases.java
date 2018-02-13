package Infaces;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CarTestCases {
    private Car car;

    @Before
    public void setUp() {
        car = new Car();
    }


//    //TC 1
//    @Test
//    public void moveForwardTest() {
//        car.getSituation().stPosition = 0;
//        car.moveForward();
//        //Assert.assertEquals(0, car.getCarPosition());
//
//    }
//
//    //TC 2
//    @Test
//    public void moveForwardTest2() {
//        car.getSituation().stPosition = 500;
//        car.moveForward();
//        Assert.assertEquals(499, car.getCarPosition());
//    }
//
//    //TC 3
//    @Test
//    public void moveForwardTest3() {
//        car.getSituation().stPosition = 400;
//        car.moveForward();
//        Assert.assertEquals(399, car.getCarPosition());
//    }
//
//    //TC 4
//    @Test
//    public void moveForwardTest4() {
//        car.getSituation().stPosition = 400;
//        car.moveForward();
//        Assert.assertEquals(400, car.getCarPosition());
//    }

    //TC 5
    @Test
    public void whereIsTest() {
        int xPos = 20;
        int yPos = 55;
        int[] coordinates = Car.whereIs(xPos, yPos);

        assertEquals([14, 55], Car.whereIs(xPos, yPos));
    }


    //TC 6
    @Test
    public void whereIsBadXValueTest() {
        int xPos = 14;
        int yPos = 50;
        int[] coordinates = Car.whereIs(xPos, yPos);

        assertEquals("Car is out of bounds", Car.whereIs(xPos, yPos));

    }
    //TC 7
    @Test
    public void whereIsBadYValuesTest() {
        int xPos = 16;
        int yPos = 101;
        int[] coordinates = Car.whereIs(xPos, yPos);

        assertEquals("Car is out of bounds", Car.whereIs(xPos, yPos));

    }
    //TC 8
    @Test
    public void whereIsEdgeValuesTest() {
        int xPos = 15;
        int yPos = 100;
        int[] coordinates = Car.whereIs(xPos, yPos);

        assertEquals([15,100], Car.whereIs(xPos, yPos));

    }
    //TC 10
    @Test
    public void whereIsBadValuesTest() {
        int xPos = 2;
        int yPos = 2;
        int[] coordinates = Car.whereIs(xPos, yPos);

        assertEquals("Car is out of bounds", Car.whereIs(xPos, yPos));

    }

    //TC 11
    @Test
    public void oneFaultySensorValueCarDetectedTest() {
        Car testCar = new Car(-1, 5, 5, 10);

        assertEquals("Warning: Car detected.", testCar.leftLaneDetect(2));
    }
    //TC 12
    @Test
    public void twoFaultySensorValuesCarDetectedTest() {
        Car testCar = new Car(-1, -1, 5, 10);

        assertEquals("Warning: Car detected.", testCar.leftLaneDetect(2));
    }
    //TC 13
    @Test
    public void threeFaultySensorValuesCarDetectedTest() {
        Car testCar = new Car(-1, -1, 5, -1);

        assertEquals("Error: Values not reliable.", testCar.leftLaneDetect(2));
    }
    //TC 14
    @Test
    public void carDetectedInLeftLaneTest() {
        Car testCar = new Car(10, 10, 5, 2);

        assertEquals("Warning: Car detected.", testCar.leftLaneDetect(2));
    }
    //TC 15
    @Test
    public void emptyLeftLaneDetectTest() {
        Car testCar = new Car(10, 10, 50, 50);

        assertEquals("No car detected on the left lane.", testCar.leftLaneDetect(2));
    }

    //TC 16
    @Test
    public void carChangeLaneTestRightmostLane() {
        Car testCar = new Car(10, 10, 10, 10);
        testCar.setCarPosition(15,0);

        assertEquals("Lane successfully changed", testCar.changeLane());
    }
    //TC 17
    @Test
    public void carCannotChangeLaneTestLeftmostLane() {
        Car testCar = new Car(10, 10, 10, 10);
        testCar.setCarPosition(5,0);
        assertEquals("Lane could not be changed", testCar.changeLane());
    }
}

