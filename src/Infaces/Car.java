/**
 * 
 */
package Infaces;

import java.util.ArrayList;


/**
 * @author chiefcorlyns
 *
 */

public class Car implements CarInterface{
	private CarSituation carSituation;
	private CarPosition carPosition;
	private ArrayList <Integer> openSpaces;
	public  int sensorCount1;
	public  int sensorCount2;
	
	public Car () {
		this.openSpaces   = new ArrayList<>();
		this.carSituation = new CarSituation(500, false);
		this.carPosition = new CarPosition(this.carSituation.stPosition, openSpaces);
		this.sensorCount1 = 0;
		this.sensorCount2 = 0;
		
		
		
	}
	
@Override
	public CarPosition moveForward() {
	if(this.carSituation.getPosition() > 0 && this.carSituation.stPosition <= 500){
        this.carSituation.stPosition--;
       // isEmpty();
    }
    else {
        System.out.println("Cant go forward");
    }
    return this.carPosition;
}
	public CarPosition getCarPosition() {
		// TODO Auto-generated method stub
		return carPosition;
	}

	public CarSituation getSituation() {
		// TODO Auto-generated method stub
		return carSituation;
	}
	
	public int  getPosition() {
		return this.carPosition.getPosition() ;
	}

	
}
