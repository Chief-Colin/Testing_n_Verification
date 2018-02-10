package Infaces;

public class Radar {
    private int sensorValue;

    public Radar(int sensorValue) {
        this.sensorValue = sensorValue;
    }

    public void setSensorValue(int sensorValue) {
        this.sensorValue = sensorValue;
    }

    public int getSensorValue() {
        return sensorValue;
    }
}
