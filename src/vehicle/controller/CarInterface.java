/**
 *
 */
package vehicle.controller;

public interface CarInterface {

 

    /**
     * DESCRIPTION:
     * Name - whereIs
     * Input Argument Types - No input argument types
     * Output Return Types - int Array [x,y]
     * - x = x-coordinate
     * - y = y-coordinate
     *
     * PRE-CONDITION: The x and y instance variables of the Car are initialized
     *
     * POST-CONDITION: Returns the x and y coordinates of the Car in an int Array containing [x,y].
     *
     * TEST-CASES: 5-6
     **/

    int[] whereIs();

    //--------------------------------------------------------------------------------------------------//

    /**
     * DESCRIPTION:
     * Name - leftLaneDetect
     * Input Argument Types - int queryCount
     * Output Return Types - String
     *
     * PRE-CONDITION: The Radar and Lidar instance variables of the Car are initialized
     *
     * POST-CONDITION: Returns the appropriate String message based on lane detection.
     *
     * TEST-CASES: 7-12
     **/

    String leftLaneDetect(int queryCount);

    //--------------------------------------------------------------------------------------------------//


    String changeLane();

    //---------------------------------------------------------------------------------------------------//
    /**
        * DESCRIPTION:
        * Name - moveForward
        * Input Argument Types - null
        * Output Return Types - coordintates(x, y)
        *
        * PRE-CONDITION: The value of the y- axis must be less than or equal to 95
        *
        * POST-CONDITION: It Returns y and x axis coordinates that is (0, 0)
        *
        * TEST-CASES: 1-4
        **/
    int moveForward();

}