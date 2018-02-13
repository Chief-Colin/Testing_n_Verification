package Infaces;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CarTestCases {
    private Car car;

    @Before
    public void setUp() {
        car = new Car();
    }


    //TC 1
    @Test
    public void moveForwardTest() {
        car.moveForward(0, 95);
        Assert.assertEquals(100, car.moveForward(0, 95));
    }

    //TC 2
    @Test
    public void moveForwardTest2() {
        car.moveForward(95, 0);
        Assert.assertEquals(5, car.moveForward(95, 0));
    }

    //    //TC 3
    @Test
    public void moveForwardTest3() {
        car.moveForward(0, 100);
        Assert.assertEquals(1, car.moveForward(0, 100));
    }

    //    //TC 4
    @Test
    public void moveForwardTest4() {
        Assert.assertEquals(55, car.moveForward(5, 50));
    }

    //TC 5
    @Test
    public void whereIsTest() {
        int xPos = 5;
        int yPos = 100;
        car.setCarPosition(xPos, yPos);
        int[] whereIsCar = car.whereIs();

        assertEquals(car.xPos, whereIsCar[0]);
    }


    // TC 6
    @Test
    public void whereIsBadXValueTest() {
        car.setCarPosition(0, 100);
        int[] carPos = car.whereIs();
        car.setCarPosition(100, 5);


        assertEquals(carPos[0], car.whereIs()[0]);
        assertEquals(carPos[1], car.whereIs()[1]);
    }

    //    //TC 7
    @Test
    public void whereIsBadYValueTest() {
        car.setCarPosition(0, 100);
        int[] carPos = car.whereIs();
        car.setCarPosition(0, 200);


        assertEquals(carPos[0], car.whereIs()[0]);
        assertEquals(carPos[1], car.whereIs()[1]);
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
    public void carChangeLaneTestRightmostLaneBeginningOfStreet() {
        Car testCar = new Car(10, 10, 10, 10);
        testCar.setCarPosition(15, 0);

        assertEquals("Lane successfully changed", testCar.changeLane());
    }

    //TC 17
    @Test
    public void carChangeLaneTestMiddleLaneMidWayOfStreet()  {
        Car testCar = new Car(10, 10, 10, 10);
        testCar.setCarPosition(10, 50);
        assertEquals("Lane successfully changed", testCar.changeLane());
    }

    //TC 18
    @Test
    public void carCannotChangeLaneTestLeftmostLaneBeginningOfStreet() {
        Car testCar = new Car(10, 10, 10, 10);
        testCar.setCarPosition(5, 0);
        assertEquals("Lane could not be changed", testCar.changeLane());
    }

    //TC 19
    @Test
    public void carCannotChangeLaneTestRightmostLaneEndOfStreet() {
        Car testCar = new Car(10, 10, 10, 10);
        testCar.setCarPosition(15, 96);
        assertEquals("Lane could not be changed", testCar.changeLane());
    }
}

