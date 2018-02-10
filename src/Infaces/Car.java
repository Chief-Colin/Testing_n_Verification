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
        this.xPos = 0;
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

    @Override
    public int[] whereIs() {
        int[] carCoordinates = new int[2];
        carCoordinates[0] = xPos;
        carCoordinates[1] = yPos;

        return carCoordinates;
    }

    @Override
    public String changeLane() {
        return null;
    }

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