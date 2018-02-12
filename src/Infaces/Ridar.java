package Infaces;

import java.util.Random;

public class Ridar {
	int ridarSensor;	
	
	
	public Ridar (int sensor){

	Random ran = new Random();
	this.ridarSensor = ran.nextInt(sensor);
	}
	
	public int getRidar() {
		return ridarSensor;
	}
}
