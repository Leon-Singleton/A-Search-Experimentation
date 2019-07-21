
/**
* PuzzleState.java
* The state of an 8 puzzle problem
*/

import java.util.*;

public class PuzzleState extends SearchState {

	//these are the instance variables for the positions of the eight puzzle array
	private int[][] eightPuzzle = new int[3][3];
	private int a;
	private int b;
	private int c;
	private int d;
	private int e;
	private int f;
	private int g;
	private int h;
	private int i;

	/**
	 * constructor
	 * 
	 * @param puzzleArray
	 *            of board
	 */
	public PuzzleState(int a, int b, int c, int d, int e, int f, int g, int h, int i) {

		//sets the instnace variables as the parameters passed into this 
		//constructor and then uses them to set teh initail eight puzzle array
		//states
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
		this.g = g;
		this.h = h;
		this.i = i;

		eightPuzzle[0][0] = a;
		eightPuzzle[0][1] = b;
		eightPuzzle[0][2] = c;
		eightPuzzle[1][0] = d;
		eightPuzzle[1][1] = e;
		eightPuzzle[1][2] = f;
		eightPuzzle[2][0] = g;
		eightPuzzle[2][1] = h;
		eightPuzzle[2][2] = i;

	}

	/**
	 * accessor for puzzleArray
	 */

	public int[][] getEightPuzzle() {
		return eightPuzzle;
	}

	/**
	 * goalP
	 * 
	 * @param searcher
	 *            - the current search
	 */
	public boolean goalP(Search searcher) {
		PuzzleSearch eightPuzzleSearch = (PuzzleSearch) searcher;
		//uses the accessor in the PuzzleSearch class to set the target array 
		int[][] target = eightPuzzleSearch.getTarget(); 
		//compares the positions of the target array with the eightpuzzle instance array to see if they match
		//keeps returning false if there are any positions that do not match
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (target[i][j] != eightPuzzle[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * getSuccessors
	 * 
	 * @param searcher
	 *            - the current search
	 */
	public ArrayList<SearchState> getSuccessors(Search searcher) {
		PuzzleSearch pSearcher = (PuzzleSearch) searcher;
		
		//stores an arraylist of puzzle states
		ArrayList<PuzzleState> puzzleStates = new ArrayList<PuzzleState>(); 
		ArrayList<SearchState> stateList = new ArrayList<SearchState>();

		//checks the 8 puzzle board and depending on the position of the empty space (0) adds states to the 
		//puzzleStates arraylist that outline the possible moves that can be made
		if (eightPuzzle[0][0] == 0) {
			puzzleStates.add(new PuzzleState(b, a, c, d, e, f, g, h, i));
			puzzleStates.add(new PuzzleState(d, b, c, a, e, f, g, h, i));
		}
		else if (eightPuzzle[0][1] == 0) {
			puzzleStates.add(new PuzzleState(b, a, c, d, e, f, g, h, i));
			puzzleStates.add(new PuzzleState(a, c, b, d, e, f, g, h, i));
			puzzleStates.add(new PuzzleState(a, e, c, d, b, f, g, h, i));
		}
		else if (eightPuzzle[0][2] == 0) {
			puzzleStates.add(new PuzzleState(a, c, b, d, e, f, g, h, i));
			puzzleStates.add(new PuzzleState(a, b, f, d, e, c, g, h, i));
		}
		else if (eightPuzzle[1][0] == 0) {
			puzzleStates.add(new PuzzleState(d, b, c, a, e, f, g, h, i));
			puzzleStates.add(new PuzzleState(a, b, c, e, d, f, g, h, i));
			puzzleStates.add(new PuzzleState(a, b, c, g, e, f, d, h, i));
		}
		else if (eightPuzzle[1][1] == 0) {
			puzzleStates.add(new PuzzleState(a, e, c, d, b, f, g, h, i));
			puzzleStates.add(new PuzzleState(a, b, c, e, d, f, g, h, i));
			puzzleStates.add(new PuzzleState(a, b, c, d, h, f, g, e, i));
			puzzleStates.add(new PuzzleState(a, b, c, d, f, e, g, h, i));
		}
		else if (eightPuzzle[1][2] == 0) {
			puzzleStates.add(new PuzzleState(a, b, f, d, e, c, g, h, i));
			puzzleStates.add(new PuzzleState(a, b, c, d, f, e, g, h, i));
			puzzleStates.add(new PuzzleState(a, b, c, d, e, i, g, h, f));
		}
		else if (eightPuzzle[2][0] == 0) {
			puzzleStates.add(new PuzzleState(a, b, c, g, e, f, d, h, i));
			puzzleStates.add(new PuzzleState(a, b, c, d, e, f, h, g, i));
		}
		else if (eightPuzzle[2][1] == 0) {
			puzzleStates.add(new PuzzleState(a, b, c, d, h, f, g, e, i));
			puzzleStates.add(new PuzzleState(a, b, c, d, e, f, h, g, i));
			puzzleStates.add(new PuzzleState(a, b, c, d, e, f, g, i, h));
		}
		else if (eightPuzzle[2][2] == 0) {
			puzzleStates.add(new PuzzleState(a, b, c, d, e, f, g, i, h));
			puzzleStates.add(new PuzzleState(a, b, c, d, e, i, g, h, f));
		}

		// casts the puzzle states as search states in stateList
		for (PuzzleState counter : puzzleStates)
			stateList.add((SearchState) counter);

		return stateList;

	}

	/**
	 * sameState - do 2 nodes have the same state?
	 * 
	 * @param s2
	 *            second state
	 */
	public boolean sameState(SearchState s2) {
		PuzzleState ps2 = (PuzzleState) s2;
		int[][] arrayState = ps2.getEightPuzzle();
		//this check is used to return true or false depending on whether two nodes have the same state
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (arrayState[i][j] != eightPuzzle[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * toString
	 */
	public String toString() {
		String printBoard = "\n";
		//this series of for loops is used to append the contents of teh eightpuzzle array so 
		//that it is printed to the console in a board shape (3*3)
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				printBoard = printBoard + eightPuzzle[i][j] + " ";
			}
			printBoard = printBoard + "\n";
		}
		return printBoard;
	}

}
