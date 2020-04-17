package wwwordz.puzzle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import wwwordz.shared.Puzzle.Solution;
import wwwordz.puzzle.Trie.Search;
import wwwordz.shared.Puzzle;
import wwwordz.shared.Table;
import wwwordz.shared.Table.Cell;

/**
 * A puzzle generator
 * Creates a puzzle with many srambled words contained in a dictionary
 * @author Eduardo Morgado (up201706894)
 * @author Ângelo Gomes (up201703990)
 * @since April 2020
 */
public class Generator {
	private final Dictionary dictionary = Dictionary.getInstance();
	private final Random rand;
	
	public Generator() {
		rand = new Random();
	}
	
	/**
	 * Generate a high quality puzzle with many words in it
	 * 
	 * Iterate over all free cells in a table
	 * Randomly select cells and assign to them a random word on the dictionary
	 * Calculate solutions for table
	 * Return the puzzle
	 * @return Puzzle
	 */
	public Puzzle generate() {
		Table table = new Table();
		List<Cell> free = null;
		
		//For all available cells, get a random word and fill them
		while((free = table.getEmptyCells()).size() > 0) {
			Cell empty = free.get(rand.nextInt(free.size()));
			String word = dictionary.getRandomLargeWord();
			
			//Place chars of word in cell and its neighbors
			fillCellNeighbors(table,empty,word,0);			
		}
		Puzzle puzzle = new Puzzle();
		puzzle.setTable(table);
		//Calculate solutions for this table
		List<Solution> solutions = getSolutions(table);
		//Update puzzle solutions
		puzzle.setSolutions(solutions);
		return puzzle;
	}
	
	/**
	 * Method to recursively save a word to neighboring cells
	 * 	Save current unsaved letter to cell
	 * 	Randomly pick valid neighbors to save next letters
	 * 	Neighbors have to be free or have consumed desired letter
	 * 
	 * @param Table table
	 * @param Cell to fill
	 * @param String word being saved in puzzle
	 * @param int index for letter to be saved
	 */
	private void fillCellNeighbors(Table table, Cell cell, String word, int index) {
		cell.setLetter(word.charAt(index));
		//word has next char?
		if(++index < word.length()) {
			//Randomize order of neighbors
			List<Cell> neighbors = table.getNeighbors(cell);
			Collections.shuffle(neighbors);
			
			//Iterate over neighbors, if free or have same letter as current in index, fill
			//Use for in case all cells fail to prevent loop
			for(Cell neighbor : neighbors) {
				if(neighbor.isEmpty() || neighbor.getLetter() == word.charAt(index)) {
					fillCellNeighbors(table,neighbor,word,index);
					break;
				}
			}			
		}		
	}
	
	/**
	 * Return a list of solutions for this table
	 * 
	 * Solutions have at least 2 letters
	 * Different solutions for same word are discarded
	 * 
	 * Iterate over cells, start dictionary search checking if letter exists
	 * Get neighbors, for each check if search can continue
	 * 
	 * If word if found, add to list of solutions
	 * Keeps a list of visited cells 
	 * @param Table to find solutions
	 * @return list of solutions for table
	 */
	List<Solution> getSolutions(Table table){
		List<Solution> solutions = new ArrayList<>();
		
		for(Cell cell : table) {
			//TODO
		}
	}
	
}
