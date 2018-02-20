package vehicle.model;

public interface Sensor {

    /**
     * DESCRIPTION:
     * Name - getSensorValue
     * Input Argument Types -
     * Output Return Types - int
     *
     * PRE-CONDITION: Sensor has a valid value field
     *
     *
     * POST-CONDITION: Returns an int indicating the sensor value
     *
     *
     **/

    int getSensorValue();

    /**
     * DESCRIPTION:
     * Name - setSensorValue
     * Input Argument Types - int newSensorValue
     * Output Return Types -
     *
     * PRE-CONDITION: Valid integer is passed in the argument
     *
     *
     * POST-CONDITION: Sets the Sensor's sensor value field  to passed integer
     *
     *
     **/

    void setSensorValue(int newSensorValue);
}
