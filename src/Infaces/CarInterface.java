/**
 * 
 */
package Infaces;
import java.util.ArrayList;


/**
 * @author chiefcorlyns
 *
 */
public interface CarInterface {
	class CarSituation{
		
		int stPosition;
		boolean isFree;
		
		public CarSituation (int stPosition, boolean isFree) {
			
			this.stPosition = stPosition;
			this.isFree = isFree;
			
		}
		
		 public int getPosition(){
            return this.stPosition;
        }
	}
		 
		 class CarPosition{
		        int streetPosition;
		        ArrayList<Integer>parkingSpaces;
		        public CarPosition(int streetPosition, ArrayList parkingSpaces){
		            this.streetPosition = streetPosition;
		            this.parkingSpaces = parkingSpaces;
		        }
		        public int getPosition(){
		            return this.streetPosition;
		        }
		        public ArrayList<Integer> getParkingSpaces(){
		            return this.parkingSpaces;
		        }
		    }

		 CarPosition moveForward(); 
	}

	





