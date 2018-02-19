package vehicle.model;

public class Radar implements SensorInterface{
    private int sensorValue;

    public Radar(int sensorValue) {
        this.sensorValue = sensorValue;
    }
    @Override
    public void setSensorValue(int sensorValue) {
        this.sensorValue = sensorValue;
    }
    @Override
    public int getSensorValue() {
        return sensorValue;
    }
}
