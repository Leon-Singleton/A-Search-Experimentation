
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
	public PuzzleState(int a, int b, int c, int d, int e, int f, int g, int h, int i, int estRemCost) {

		//sets the instnace variables as the parameters passed into this 
		//constructor and then uses them to set teh initail eight puzzle array
		//states
		localCost = 1;
		
		this.estRemCost=estRemCost;
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

	//manhattan cost
	/*
	public int getestRemCost() {
	//here i manually set the target since i cannot pass the searcher instance into this method
		int[][] targetArray = {{1,2,3}, {4,5,6}, {7,8,0}};	
		int totalCount =0;
		
			//this series of for loops is used to calculate the manhattan cost by taking the absoloute value difference between 
			//a given position of a number and its target position for that specific number
			//this value is added to a total counter which is returned
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (targetArray[i][j] != puzzleArray[i][j]) {
						if (puzzleArray[i][j] == 0) {
							totalCount += Math.abs(2-i)+Math.abs(2-j);
						}
						else if (puzzleArray[i][j] == 1) {
							totalCount += Math.abs(0-i)+Math.abs(0-j);
						}
						else if (puzzleArray[i][j] == 2) {
							totalCount += Math.abs(0-i)+Math.abs(1-j);
						}
						else if (puzzleArray[i][j] == 3) {
							totalCount += Math.abs(0-i)+Math.abs(2-j);
						}
						else if (puzzleArray[i][j] == 4) {
							totalCount += Math.abs(1-i)+Math.abs(0-j);
						}
						else if (puzzleArray[i][j] == 5) {
							totalCount += Math.abs(1-i)+Math.abs(1-j);
						}
						else if (puzzleArray[i][j] == 6) {
							totalCount += Math.abs(1-i)+Math.abs(2-j);
						}
						else if (puzzleArray[i][j] == 7) {
							totalCount += Math.abs(2-i)+Math.abs(0-j);
						}
						else if (puzzleArray[i][j] == 8) {
							totalCount += Math.abs(2-i)+Math.abs(1-j);
						}
					}
				}
			}
			return totalCount;
	}
	*/
	
	//hamming cost
	public int getestRemCost() {
		//here i manually set the target since i cannot pass the searcher instance into this method
		int[][] target = {{1,2,3}, {4,5,6}, {7,8,0}};	
		int count =0;
		//here the hamming cost is calcualted by checking each position in eightpuzzle against that
		//in the raget Array, if a position is not in its corrrect place a counter is increased by 1
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (eightPuzzle[i][j] != target[i][j]) {
				count++;	
				}
			}
		}
		return count;
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
			puzzleStates.add(new PuzzleState(b, a, c, d, e, f, g, h, i, getestRemCost()));
			puzzleStates.add(new PuzzleState(d, b, c, a, e, f, g, h, i, getestRemCost()));
		}
		else if (eightPuzzle[0][1] == 0) {
			puzzleStates.add(new PuzzleState(b, a, c, d, e, f, g, h, i, getestRemCost()));
			puzzleStates.add(new PuzzleState(a, c, b, d, e, f, g, h, i, getestRemCost()));
			puzzleStates.add(new PuzzleState(a, e, c, d, b, f, g, h, i, getestRemCost()));
		}
		else if (eightPuzzle[0][2] == 0) {
			puzzleStates.add(new PuzzleState(a, c, b, d, e, f, g, h, i, getestRemCost()));
			puzzleStates.add(new PuzzleState(a, b, f, d, e, c, g, h, i, getestRemCost()));
		}
		else if (eightPuzzle[1][0] == 0) {
			puzzleStates.add(new PuzzleState(d, b, c, a, e, f, g, h, i, getestRemCost()));
			puzzleStates.add(new PuzzleState(a, b, c, e, d, f, g, h, i, getestRemCost()));
			puzzleStates.add(new PuzzleState(a, b, c, g, e, f, d, h, i, getestRemCost()));
		}
		else if (eightPuzzle[1][1] == 0) {
			puzzleStates.add(new PuzzleState(a, e, c, d, b, f, g, h, i, getestRemCost()));
			puzzleStates.add(new PuzzleState(a, b, c, e, d, f, g, h, i, getestRemCost()));
			puzzleStates.add(new PuzzleState(a, b, c, d, h, f, g, e, i, getestRemCost()));
			puzzleStates.add(new PuzzleState(a, b, c, d, f, e, g, h, i, getestRemCost()));
		}
		else if (eightPuzzle[1][2] == 0) {
			puzzleStates.add(new PuzzleState(a, b, f, d, e, c, g, h, i, getestRemCost()));
			puzzleStates.add(new PuzzleState(a, b, c, d, f, e, g, h, i, getestRemCost()));
			puzzleStates.add(new PuzzleState(a, b, c, d, e, i, g, h, f, getestRemCost()));
		}
		else if (eightPuzzle[2][0] == 0) {
			puzzleStates.add(new PuzzleState(a, b, c, g, e, f, d, h, i, getestRemCost()));
			puzzleStates.add(new PuzzleState(a, b, c, d, e, f, h, g, i, getestRemCost()));
		}
		else if (eightPuzzle[2][1] == 0) {
			puzzleStates.add(new PuzzleState(a, b, c, d, h, f, g, e, i, getestRemCost()));
			puzzleStates.add(new PuzzleState(a, b, c, d, e, f, h, g, i, getestRemCost()));
			puzzleStates.add(new PuzzleState(a, b, c, d, e, f, g, i, h, getestRemCost()));
		}
		else if (eightPuzzle[2][2] == 0) {
			puzzleStates.add(new PuzzleState(a, b, c, d, e, f, g, i, h, getestRemCost()));
			puzzleStates.add(new PuzzleState(a, b, c, d, e, i, g, h, f, getestRemCost()));
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
