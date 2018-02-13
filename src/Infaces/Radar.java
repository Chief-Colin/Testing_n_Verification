package Infaces;

import java.util.Random;

public class Radar {
	int ridarSensor;	
	
	
	public Radar (int sensor){

	Random ran = new Random();
	this.ridarSensor = ran.nextInt(sensor);
	}
	
	public int getRidar() {
		return ridarSensor;
	}

	public int getSensorValue() {
		// TODO Auto-generated method stub
		return ridarSensor;
	}

	
}
