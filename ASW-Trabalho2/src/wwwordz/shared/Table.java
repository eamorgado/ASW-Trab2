package wwwordz.shared;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Class representing the a puzzle table.
 * 	A table is a collection of cells each indexed by row and column.
 * 
 * @author Eduardo Morgado (up201706894)
 * @author Ângelo Gomes ()
 * @since April 2020
 */
public class Table {
	private Cell[][] table;
	
	/**
	 * Nested class representing enclosing table
	 */
	static class Cell{
		private int row;
		private int column;
		private char letter;
		
		/**
		 * Empty Constructor
		 * @param void
		 */
		Cell(){}
		
		/**
		 * Create empty cell given row and column
		 * @param int row
		 * @param int column
		 */
		Cell(int row, int column){
			this.row = row;
			this.column = column;
			this.letter = ' ';
		}
		
		/**
		 * Create cell given its letter and row and column
		 * @param int row
		 * @param int column
		 * @param char letter
		 */
		Cell(int row, int column, char letter){
			this(row,column);
			this.letter = letter;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cell other = (Cell) obj;
			return column == other.column && letter == other.letter && row == other.row;
		}
		
		/**
		 * This method returns the letter in the cell
		 * @param void
		 * @return char
		 */
		public char getLetter() {return letter;}
		
		/**
		 * Method to return row of cell
		 * @param void
		 * @return int
		 */
		public int getRow() {return row;}
		
		/**
		 * Method to return column of cell
		 * @param void
		 * @return int
		 */
		public int getColumn() {return column;}
		
		@Override
		public int hashCode() {
			return Objects.hash(column, letter, row);
		}
		
		/**
		 * Method that checks if cell is empty/blank
		 * @param void
		 * @return boolean
		 */
		public boolean isEmpty() {return letter == ' ';}
		
		/**
		 * Method to set letter of cell
		 * @param char letter
		 * @return void
		 */
		public void setLetter(char letter) {letter = letter;}
		
		@Override
		public String toString() {
			return "Cell [row=" + row + ", column=" + column + ", letter=" + letter + "]";
		}
		
	}
	private class CellIterator implements Iterator<Table.Cell>{
		private int row;
		private int column;
		
		CellIterator(){
			row = column = 0;
		}
		
		@Override
		public boolean hasNext() {
			return row <= table[0].length;
		}
		
		@Override
		public Cell next() {
			Cell cell = table[row][column++];
			if(column > table[0].length) {
				column = 1;
				row++;
			}
			return cell;
		}
		
		@Override
		public void remove() {
			Cell cell = table[row][column];
			cell.setLetter(' ');
			if(column == 0) {
				column = table[0].length - 1;
				row = row > 0? --row : 0;
			}else column--;
		}
	}

	public Table(){
		//TODO
	}
	
	public Table(String[] data) {
		//TODO
	}
	
	public Iterator<Cell> iterator(){
		//TODO
	}
	
	public char getLetter(int row, int column) {return table[row][column].getLetter();}
	public void setLetter(int row, int column,char letter) {table[row][column].setLetter(letter);}
	public List<Table.Cell> getEmptyCells(){
		//TODO
	}
	public List<Table.Cell> getNeighbors(Table.Cell cell){
		//TODO
	}
	public Table.Cell getCell(int row, int column){return table[row][column];}
	
	@Override
	public String toString() {
		return "Table [" + (table != null ? "table=" + Arrays.toString(table) : "") + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(table);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Table))
			return false;
		Table other = (Table) obj;
		return Arrays.deepEquals(table, other.table);
	}
}
