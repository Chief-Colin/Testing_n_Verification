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


    public Car(int xPos, int yPos) {
        this.openSpaces = new ArrayList<>();
        this.carSituation = new CarSituation(500, false);
        this.carPosition = new CarPosition(this.carSituation.stPosition, openSpaces);
        this.sensorCount1 = 0;
        this.sensorCount2 = 0;
        this.xPos = xPos;
        this.xPos = yPos;
    }

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

    public void setCarPosition(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }
}
