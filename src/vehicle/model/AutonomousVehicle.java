/**
 *
 */
package vehicle.model;

public interface AutonomousVehicle {


    /**
     * DESCRIPTION:
     * Name - whereIs
     * Input Argument Types - No input argument types
     * Output Return Types - int Array [x,y]
     * - x = x-coordinate
     * - y = y-coordinate
     * <p>
     * PRE-CONDITION: The x and y instance variables of the Car are initialized
     * <p>
     * POST-CONDITION: Returns the x and y coordinates of the Car in an int Array containing [x,y].
     * <p>
     * TEST-CASES: 5-6
     **/

    int[] whereIs();

    //--------------------------------------------------------------------------------------------------//

    /**
     * DESCRIPTION:
     * Name - leftLaneDetect
     * Input Argument Types - int queryCount
     * Output Return Types - String
     * <p>
     * PRE-CONDITION: The Radar and Lidar instance variables of the Car are initialized
     * <p>
     * POST-CONDITION: Returns the appropriate String message based on lane detection.
     * <p>
     * TEST-CASES: 11-15, 20, 21.
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
     * <p>
     * PRE-CONDITION: The value of the y- axis must be less than or equal to 95
     * <p>
     * POST-CONDITION: It Returns y and x axis coordinates that is (0, 0)
     * <p>
     * TEST-CASES: 1-4
     **/
    int moveForward();

}