package Infaces;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;


public class CarTestCases {
    private Car car;

    @Before
    public void setUp() {
        car = new Car();
    }


//TC 
    @Test
   public void moveForwardTest() {        
           car.moveForward(0,95 );
           Assert.assertEquals(100, car.moveForward(0, 95));
 }

   //TC 2
 @Test
 public void moveForwardTest2() {
     car.moveForward(95,0 );
     Assert.assertEquals(5, car.moveForward(95, 0));
 }

//    //TC 3
    @Test
    public void moveForwardTest3() {
        car.moveForward(0,100 );
        Assert.assertEquals("car cannot move", car.moveForward(0, 100));
    }

//    //TC 4
  @Test
  public void moveForwardTest4() {
      car.moveForward(5,50 );
      Assert.assertEquals(55, car.moveForward(5, 55));
   }

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

