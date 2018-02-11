/**
 *
 */
package Infaces;

import java.util.ArrayList;

public interface CarInterface {

//    int moveForward() ;
/**
 DESCRIPTION:
 Name - whereIs
 Input Argument Types - No input argument types
 Output Return Types - int Array [x,y]
 - x = x-coordinate
 - y = y-coordinate

 PRE-CONDITION: The x and y instance variables of the Car are initialized

 POST-CONDITION: Returns the x and y coordinates of the Car in an int Array containing [x,y].

 TEST-CASES: 5-6

 **/

    int[] whereIs();

    //--------------------------------------------------------------------------------------------------//

    String leftLaneDetect(int queryCount);

    String changeLane();



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

	





