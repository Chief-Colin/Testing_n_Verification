package Infaces;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import Infaces.Car;


public class CarTestCases {
	 Car car;
	    @Before
	    public void setUp(){
	        car = new Car();

	    }


//TC 1
@Test
public void moveForwardTest1(){
    car.getSituation().stPosition = 190;
    car.distanceCovered = 10;
    car.moveForward1(5);
    Assert.assertEquals(15,car.distanceCovered);
}

//TC 2
//@Test
//public void moveForwardTest2(){
//   car.getSituation().stPosition = 100;
//    car.moveForward();
//    Assert.assertEquals(99,car.getCarPosition());
//}

//TC 3
//@Test
//public void moveForwardTest3(){
 //   car.getSituation().stPosition = 90;
 //   car.moveForward();
  //  Assert.assertEquals(99,car.getCarPosition());
//}

//TC 4
//@Test
//public void moveForwardTest4(){
//    car.getSituation().stPosition = 90;
//    car.moveForward();
//    Assert.assertEquals(90,car.getCarPosition());
//}

// TC 2
@Test
public void isQueryTest1(){
    car.getSituation().stPosition = 100;
    car.emptyCounter = 3;
    int actual = car.query();
   // if (actual > 100){
       // Assert.assertEquals(4,car.getIsEmptyCounter());
   // }
}

}

