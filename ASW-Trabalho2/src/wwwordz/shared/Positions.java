package wwwordz.shared;

import wwwordz.shared.Table.Cell;

/**
 * Enum representing neighbor position coordinates, relative to a cell
 * 
 * @author Eduardo Morgado (up201706894)
 * @author Ângelo Gomes (up201703990)
 * @since April 2020
 */
enum Positions{
	UP(1,0), UP_RIGHT(1,1),
	RIGHT(0,1),
	DOWN_RIGHT(-1,1), DOWN(-1,0), DOWN_LEFT(-1,-1),
	LEFT(0,-1),
	UP_LEFT(1,-1);
	
	private int row, column;
	private Positions(int row,int column) {
		this.row = row;
		this.column = column;
	}
	
	public int getRow() {return this.row;}
	public int getColumn() {return this.column;}
	public int calRow(Cell cell) {return row + cell.getRow();}
	public int calCol(Cell cell) {return column + cell.getColumn();}
}
