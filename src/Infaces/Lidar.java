package Infaces;

import java.util.Random;

public class Lidar {
	int lidarSensor;
	
	public Lidar (int sensor) {
		Random ran = new Random();
		this.lidarSensor = ran.nextInt(sensor);
		
	}
	
	public int getLidar() {
		return this.lidarSensor;
	}

}
