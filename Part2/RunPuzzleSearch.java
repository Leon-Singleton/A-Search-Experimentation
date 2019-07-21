/**
  * RunPuzzleSearch.java
  *
  *
  * 2013 version
  *
  * @author <a href="mailto: "Phil Green</a>
  * @version 1

  run a puzzle search

*/

import sheffield.*;
import java.util.*;

public class RunPuzzleSearch {	
	
public static void main(String[] arg) {

   EpuzzGen gen = new EpuzzGen(12345); //create 8 puzzle generator
   int[][] puzz=gen.puzzGen(6); //generate a puzzle
   // create an EasyWriter
   EasyWriter screen = new EasyWriter();
   
   //this is the target that the seartch is trying to find
   PuzzleSearch search = new PuzzleSearch(1,2,3,4,5,6,7,8,0);
   
   //sets the values of the first instance of the 8 puzzle game by passing them in from the values of the 8 puzzle generated array
   SearchState init_state = (SearchState) new PuzzleState(puzz[0][0],puzz[0][1],puzz[0][2],puzz[1][0],puzz[1][1],puzz[1][2],puzz[2][0],puzz[2][1],puzz[2][2],0);
    
  // SearchState init_state = (SearchState) new PuzzleState(1,0,3,4,2,6,7,5,8,0);
   //SearchState init_state = (SearchState) new PuzzleState(4,1,3,7,2,5,0,8,6);
   //SearchState init_state = (SearchState) new PuzzleState(2,3,6,1,5,8,4,7,0);

   String output = search.runSearch(init_state, "AStar");
   screen.println(output);
}
}
