package wwwordz.puzzle;

import java.util.List;
import java.util.Random;

import wwwordz.puzzle.Puzzle.Solution;
import wwwordz.puzzle.Table.Cell;
import wwwordz.puzzle.Trie.Search;
import wwwordz.shared.Puzzle;
import wwwordz.shared.Table;

public class Generator {
	private final Dictionary dictionary = Dictionary.getInstance();
	private final Random rand;
	
	public Generator() {
		rand = new Random();
	}
	
	/**
	 * Generate a high quality puzzle with many words in it
	 * @return Puzzle
	 */
	public Puzzle generate() {
		Puzzle puzzle = new Puzzle();
		Table table = new Table();
		List<Cell> free = null;
		
		while((free = table.getEmptyCells()).size() > 0) {
			Cell empty = free.get(rand.nextInt(free.size()));
			String word = dictionary.getRandomLargeWord();
			
			
		}
	}
	
}
