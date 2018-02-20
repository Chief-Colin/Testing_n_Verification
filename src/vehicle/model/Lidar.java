package vehicle.model;

public class Lidar implements Sensor {
    private int sensorValue;

    public Lidar(int sensorValue) {
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
