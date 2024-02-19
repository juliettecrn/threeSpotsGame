package fr.tsg.object;

public class Cell {
	int x;
	int y;
	Position position = new Position(x, y);
	int point;
	
	public Cell(int x, int y, int point) {
		this.point = point;
		this.x =   x;
		this.y = y;
	}
	

}
