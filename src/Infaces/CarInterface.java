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
		
		int stPosition=0;
		boolean isFree;
		
		public CarSituation (int stPosition, boolean isFree) {
			
			this.stPosition = stPosition;
			this.isFree = isFree;
			
		}
		
		 public int getPosition(){
            return this.stPosition;
        }
	}

	int moveForward1(int move);

	CarPosition moveForward();
	int 	query();
		

	}	 
	class CarPosition{
		        int stPosition;
		        ArrayList<Integer>openSpaces;
		       
		        public CarPosition(int stPosition, ArrayList openSpaces){
		            this.stPosition = stPosition;
		            this.openSpaces = openSpaces;
		        }
		        public int getPosition(){
		            return this.stPosition;
		        }
		        public ArrayList<Integer> getOpenSpaces(){
		            return this.openSpaces;
		        }
		    
		        class CarSituation {
		            int streetPosition;
		            boolean isMovable;

		            public CarSituation(int streetPosition, boolean isMovable){
		                this.streetPosition = streetPosition;
		                this.isMovable = isMovable;
		            }
		            public int getPosition(){
		                return this.streetPosition;
		            }
		            public boolean isMovable(){
		                return this.isMovable;
		            }
		        }

		

		

		
	}

	





