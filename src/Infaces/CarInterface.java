/**
 *
 */
package Infaces;

import java.util.ArrayList;

public interface CarInterface {

//    int moveForward(Car car) ;
/**
 DESCRIPTION:
 Name -
 Input Argument Types -
 Output Return Types -
 -
 -
 -
 -
 -

 PRE-CONDITION:

 POST-CONDITION:

 TEST-CASES:

 **/

//    int[] whereIs();
//
//    String leftLaneDetect();
//
//    String changeLane();



    class CarSituation {

        int stPosition;
        boolean isFree;

        public CarSituation(int stPosition, boolean isFree) {

            this.stPosition = stPosition;
            this.isFree = isFree;

        }

        public int getPosition() {
            return this.stPosition;
        }
    }


    class CarPosition {
        int streetPosition;
        ArrayList<Integer> parkingSpaces;

        public CarPosition(int streetPosition, ArrayList parkingSpaces) {
            this.streetPosition = streetPosition;
            this.parkingSpaces = parkingSpaces;
        }

        public int getPosition() {
            return this.streetPosition;
        }

        public ArrayList<Integer> getParkingSpaces() {
            return this.parkingSpaces;
        }
    }

    CarPosition moveForward();
}

	





