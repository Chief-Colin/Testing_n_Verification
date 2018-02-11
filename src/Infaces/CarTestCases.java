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

    }
    //TC 6
    @Test
    public void WhereIsBadValuesTest() {

    }
    //TC 7
    @Test
    public void oneFaultySensorValueTest() {
        Car testCar = new Car(-1, 5, 5, 10);

        assertEquals("Warning: Car detected.", testCar.leftLaneDetect(2));
    }
    //TC 8
    @Test
    public void twoFaultySensorValuesTest() {
        Car testCar = new Car(-1, -1, 5, 10);

        assertEquals("Warning: Car detected.", testCar.leftLaneDetect(2));
    }
    //TC 9
    @Test
    public void threeFaultySensorValuesTest() {
        Car testCar = new Car(-1, -1, 5, -1);

        assertEquals("Error: Values not reliable.", testCar.leftLaneDetect(2));
    }
    //TC 10
    @Test
    public void noCarDetectedOnLeftLaneTest() {

    }
    //TC 11
    @Test
    public void carDetectedOnLeftLaneTest() {

    }
    //TC 12
    @Test
    public void carChangeLaneTest() {
        Car testCar = new Car(10, 10, 10, 10);
        testCar.setCarPosition(15,0);

        assertEquals("Lane successfully changed", testCar.changeLane());
    }
    //TC 13
    @Test
    public void carCannotChangeLaneTest() {
        Car testCar = new Car(10, 10, 10, 10);
        testCar.setCarPosition(5,0);
        assertEquals("Lane could not be changed", testCar.changeLane());
    }
}

