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
public void setUp() {
car = new Car();
		//fail("yess!!!");
}


//TC 1
@Test
public void moveForwardTest() {
	car.getSituation().stPosition = 0;
	car.moveForward();
	//Assert.assertEquals(0, car.getCarPosition());
	
	
}

//TC 2
@Test
public void moveForwardTest2(){
    car.getSituation().stPosition = 500;
    car.moveForward();
    Assert.assertEquals(499,car.getCarPosition());
}

//TC 3
@Test
public void moveForwardTest3(){
    car.getSituation().stPosition = 400;
    car.moveForward();
    Assert.assertEquals(399,car.getCarPosition());
}

//TC 4
@Test
public void moveForwardTest4(){
    car.getSituation().stPosition = 400;
    car.moveForward();
    Assert.assertEquals(400,car.getCarPosition());
}

}

