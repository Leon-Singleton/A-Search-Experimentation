/**
  * RunPuzzleSearch.java
  *
  *
  * 2013 version
  *
  * @author <a href="mailto: "Phil Green</a>
  * @version 1

  run a jugs search

*/

import sheffield.*;
import java.util.*;

public class RunPuzzleSearch {

public static void main(String[] arg) {

   // create an EasyWriter
   EasyWriter screen = new EasyWriter();

   PuzzleSearch search = new PuzzleSearch(1,2,3,4,5,6,7,8,0);
   SearchState init_state = (SearchState) new PuzzleState(1,0,3,4,2,6,7,5,8);
   //SearchState init_state = (SearchState) new PuzzleState(4,1,3,7,2,5,0,8,6);
   //SearchState init_state = (SearchState) new PuzzleState(2,3,6,1,5,8,4,7,0);

   String output = search.runSearch(init_state, "breadthfirst");
   screen.println(output);
}
}
