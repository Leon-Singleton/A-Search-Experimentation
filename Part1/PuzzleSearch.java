/**
*	PuzzleSearch.java
*
*	class to get the target of the 8 puzzle search
*/

import java.util.*;
public class PuzzleSearch extends Search {

	//instance variables are set for each position in the 3*3 target array
	private int[][] target = new int[3][3];
	private int a;
	private int b;
	private int c;
	private int d;
	private int e;
	private int f;
	private int g;
	private int h;
	private int i;

	public PuzzleSearch(int a, int b, int c, int d, int e, int f, int g, int h, int i) {
		
		//this constructor uses the target values passed as parameters and then sets them as their
		//respective position in the target array
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
		this.g = g;
		this.h = h;
		this.i = i;

		target[0][0] = a;
		target[0][1] = b;
		target[0][2] = c;
		target[1][0] = d;
		target[1][1] = e;
		target[1][2] = f;
		target[2][0] = g;
		target[2][1] = h;
		target[2][2] = i;

	}

	/**
	 * get method accessor for the target
	 */
	public int[][] getTarget() {
		return target;
	}

}
