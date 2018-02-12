/**
 * 
 */
package Infaces;

import java.util.ArrayList;
import java.util.Random;







/**
 * @author chiefcorlyns
 *
 */

public class Car implements CarInterface{
	private CarSituation carSituation;
	private CarPosition carPosition;
	private ArrayList <Integer> openSpaces;
	public  int sensorCounter1;
	public  int sensorCounter2;
	public  int sensorCounter3;
	public  int sensorCounter4;
	public int emptyCounter;
	
	final public int moveCar   = 5;
	public int distanceCovered = 0;
	public boolean isMovable;
	
	public Car () {
		this.openSpaces   = new ArrayList<>();
		this.carSituation = new CarSituation(100, false);
		this.carPosition = new CarPosition(this.carSituation.stPosition, openSpaces);
		this.sensorCounter1 = 0;
		this.sensorCounter2 = 0;
		this.sensorCounter3 = 0;
		this.sensorCounter4 = 0;
		
		
		
	}
	
@Override
	public CarPosition moveForward() {
	if(this.carSituation.getPosition() < 100 && this.carSituation.stPosition <= 100){
        this.carSituation.stPosition--;
       // isEmpty();
    }
    else {
        System.out.println("Cant go forward");
        //System.out.println(carSituation.stPosition);
    }
    return this.carPosition;
}

@Override
public int moveForward1(int move) {
	if(distanceCovered > 95) {
		
		System.out.println("Car cannot move");
	}
	else{
		distanceCovered += move; 
		}
	
	if (distanceCovered <= 95 ) {
		isMovable = true;
	}
	return distanceCovered;
	
}


public int query() {
   int average = 0;
   int sensor1Sum = 0;
   int sensor2Sum = 0;
   int sensor3Sum = 0;
   int sensor4Sum = 0;
   for (int i = 0; i < 5; i++) {
       Lidar lidar  = new Lidar(50);
       Ridar ridar1 = new Ridar(50);
       Ridar ridar2 = new Ridar(50);
       Ridar ridar3 = new Ridar(50);
     
       this.sensorCounter1 = 0;
       this.sensorCounter2 = 0;
       this.sensorCounter3 = 0;
       this.sensorCounter4 = 0;
       
      System.out.println(lidar);
       if (lidar.getLidar() > 20) {
           sensorCounter1++;
       }
       
       if (ridar1.getRidar() > 20) {
           sensorCounter2++;
          
       }
   
    	   
    	   if(ridar2.getRidar() > 20) {
    		   sensorCounter3++;
       }
    	 
    	   if(ridar3.getRidar() > 20) {
    		   sensorCounter4++;
    	   }
    	    System.out.println("yes "+ lidar.getLidar());
    	    System.out.println("yes2 "+ ridar1.getRidar());
    	    System.out.println("yes3 "+ ridar2.getRidar());
    	    System.out.println("yes4 "+ ridar3.getRidar());
       sensor1Sum += lidar.getLidar();
       sensor2Sum += ridar1.getRidar();
       sensor3Sum += ridar2.getRidar();
       sensor4Sum += ridar3.getRidar();
       System.out.println(sensor1Sum);
       System.out.println("sum2  "+sensor2Sum);
   }
    if (sensorCounter1 > 2 && sensorCounter2 < 3 && sensorCounter3 > 2 && sensorCounter4 > 2){
        average = sensor2Sum / 5;
       }
    else if (sensorCounter1 < 3 && sensorCounter2 > 2  && sensorCounter3 > 2 && sensorCounter4 > 2){
        average = sensor1Sum / 5;
    }
    else if (sensorCounter3 < 3 && sensorCounter2 > 2  && sensorCounter1 > 2 && sensorCounter4 > 2){
        average = sensor3Sum / 5;
    }
    else if (sensorCounter4 < 3 && sensorCounter2 > 2  && sensorCounter3 > 2 && sensorCounter1 > 2){
        average = sensor3Sum / 5;
    }
    else if (sensorCounter1 > 2 && sensorCounter2 > 2 && sensorCounter3 > 2 && sensorCounter1 > 2 ){
        average = 0;
    }
    else {
        average = ((sensor1Sum / 5) + (sensor2Sum / 5) + (sensor3Sum/5) + (sensor4Sum)) / 4;
    }
    if (average > 5) {
        if (this.emptyCounter == 4) {
            this.emptyCounter = 0;
            openSpaces.add(this.carSituation.getPosition());
            System.out.println("free space at " + this.carSituation.getPosition());
        } else {
            this.emptyCounter++;
            }
        } else {
            this.emptyCounter = 0;
        }
        return average;
}



	


	public CarPosition getCarPosition() {
		// TODO Auto-generated method stub
		return this.carPosition;
	}

	public CarSituation getSituation() {
		// TODO Auto-generated method stub
		return this.carSituation;
	}
	
	public int  getPosition() {
		return this.carPosition.getPosition() ;
	}

	 public static void main (String args[]){
	       Car car = new Car();

	       for (int i = 0; i < 20; i++){
	           car.moveForward();
	       }
	    }
}
