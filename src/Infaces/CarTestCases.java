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

    @Test
    public void whereIsTest() {

    }

    @Test
    public void WhereIsBadValuesTest() {

    }

    @Test
    public void oneFaultySensorValueTest() {
        Car testCar = new Car(-1, 5, 5, 10);

        assertEquals("Warning: Car detected.", testCar.leftLaneDetect(2));
    }

    @Test
    public void twoFaultySensorValuesTest() {
        Car testCar = new Car(-1, -1, 5, 10);

        assertEquals("Warning: Car detected.", testCar.leftLaneDetect(2));
    }

    @Test
    public void threeFaultySensorValuesTest() {
        Car testCar = new Car(-1, -1, 5, -1);

        assertEquals("Error: Values not reliable.", testCar.leftLaneDetect(2));
    }

    @Test
    public void noCarDetectedOnLeftLaneTest() {

    }

    @Test
    public void carDetectedOnLeftLaneTest() {

    }

    @Test
    public void carChangeLaneTest() {

    }

    @Test
    public void carCannotChangeLaneTest() {

    }
}

