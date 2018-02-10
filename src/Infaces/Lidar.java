package Infaces;

public class Lidar {
    private int sensorValue;

    public Lidar(int sensorValue) {
        this.sensorValue = sensorValue;
    }

    public void setSensorValue(int sensorValue) {
        this.sensorValue = sensorValue;
    }

    public int getSensorValue() {
        return sensorValue;
    }
}
