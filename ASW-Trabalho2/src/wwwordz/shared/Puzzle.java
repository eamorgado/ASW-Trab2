package wwwordz.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import wwwordz.shared.Table;
import wwwordz.shared.Table.Cell;
import wwwordz.shared.Puzzle.Solution;

/**
 * Class representing the puzzle
 *  This class contains the puzzle table and its list of solutions.
 * 
 * A table is a square grid of letters.
 * A solution is a word contained in the grid, where consecutive letters
 * 	are in neighboring cells on the grid and the letter in each cell is used only once
 * 
 * @author Eduardo Morgado (up201706894)
 * @author Ângelo Gomes (up201703990)
 * @since April 2020
 */
public class Puzzle implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Solution> solutions;
	private Table table;
	
	static class Solution implements Serializable{
		private static final long serialVersionUID = 1L;
		private List<Cell> cells;
		private String word;
		
		public Solution(){
			 cells = new ArrayList<>();;
		}
		
		public Solution(String word, List<Cell> cells) {
			this.word = word;
			this.cells = cells;
		}
		
		public String getWord() {
			return word;
		}
		
		public List<Cell> getCells(){
			return cells;
		}
		
		private int getPoints(int length) {
			return length < 3? 0
					: length == 3? 1
					: 2 * getPoints(--length) + 1;
		}
		
		public int getPoints() {
			return getPoints(word.length());
		}
	}
	
	public Puzzle() {
		table = new Table();
	}
	
	public Table getTable() {
		return table;
	}
	
	public void setTable(Table table) {
		this.table = table;
	}
	
	public List<Solution> getSolutions(){
		return solutions;
	}
	
	public void setSolutions(List<Solution> solutions) {
		this.solutions = solutions;
	}
}
