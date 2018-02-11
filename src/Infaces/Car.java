/**
 *
 */
package Infaces;

import java.util.ArrayList;


/**
 * @author chiefcorlyns
 */

public class Car implements CarInterface {
    private CarSituation carSituation;
    private CarPosition carPosition;
    private ArrayList<Integer> openSpaces;
    public int sensorCount1;
    public int sensorCount2;
    private int xPos;
    private int yPos;
    private ArrayList<Radar> radars;
    private Lidar lidar;


    public Car(int xPos, int yPos) {
        this.openSpaces = new ArrayList<>();
        this.carSituation = new CarSituation(500, false);
        this.carPosition = new CarPosition(this.carSituation.stPosition, openSpaces);
        this.sensorCount1 = 0;
        this.sensorCount2 = 0;
        this.xPos = xPos;
        this.xPos = yPos;
    }

    public Car(int frontRadarVal, int midRadarVal, int backRadarVal, int lidarVal) {
        this.xPos = 15;
        this.yPos = 0;
        Radar radar1 = new Radar(frontRadarVal);
        Radar radar2 = new Radar(midRadarVal);
        Radar radar3 = new Radar(backRadarVal);
        radars = new ArrayList<>();
        radars.add(radar1);
        radars.add(radar2);
        radars.add(radar3);
        lidar = new Lidar(lidarVal);
    }

    public Car() {}

    /*
    Checks that car position is currently within the range of the street and moves forward if it is.
    If not an error message is printed.
     */
    @Override
    public CarPosition moveForward() {
        if (this.carSituation.getPosition() > 0 && this.carSituation.stPosition <= 500) {
            this.carSituation.stPosition--;
            // isEmpty();
        } else {
            System.out.println("Cant go forward");
        }
        return this.carPosition;
    }

    /*
    Returns an array representing the position of the car.
     */
    @Override
    public int[] whereIs() {
        int[] carCoordinates = new int[2];
        carCoordinates[0] = xPos;
        carCoordinates[1] = yPos;

        return carCoordinates;
    }

    /*
    Checks that left lane is available and clear and changes lane if it is.
     */
    @Override
    public String changeLane() {
        if (leftLaneDetect(2).equals( "No car detected on the left lane." ) && this.xPos >= 10 && this.yPos <= 45) {
            moveForward();
            setCarPosition(xPos -5, this.yPos);
            return "Lane successfully changed";
        }
        else{
            return "Lane could not be changed";
        }

    }



    /*
    Repeatedly validating sensor values and checking sensor values to see if left lane is clear or if a car
    is detected. 3+ out of range sensor values returns an error message. If either one of the radar sensors or lidar
    sensor returns a value less than 6, a warning message is returned.
    This is done as many times as specified in the parameter.
     */
    @Override
    public String leftLaneDetect(int queryCount) {
        int faultyValuesCounter = 0;
        int currentQueryCounter = 1;

        while (currentQueryCounter <= queryCount) {


            for (int i = 0; i < radars.size(); i++) {
                if (radars.get(i).getSensorValue() < 0 || radars.get(i).getSensorValue() > 50) {
                    faultyValuesCounter++;
                }
            }

            if (lidar.getSensorValue() < 0 || lidar.getSensorValue() > 50) {
                faultyValuesCounter++;
            }

            if (faultyValuesCounter >= 3) {
                return "Error: Values not reliable.";
            }


            for (int i = 0; i < radars.size(); i++) {
                if (radars.get(i).getSensorValue() > 0 && radars.get(i).getSensorValue() < 6) {
                    return "Warning: Car detected.";
                }
            }

            if (lidar.getSensorValue() > 0 && lidar.getSensorValue() < 6) {
                return "Warning: Car detected.";
            }

            faultyValuesCounter = 0;
            currentQueryCounter++;
        }

        return "No car detected on the left lane.";
    }

    public void setCarPosition(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public Lidar getLidar() {
        return lidar;
    }

    public ArrayList<Radar> getRadars() {
        return radars;
    }
}