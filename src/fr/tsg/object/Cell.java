package fr.tsg.object;

public class Cell {
	
	Position position;
	int point;
	
	public Cell(int x, int y, int point) {
		this.position =  new Position(x, y);
		this.point = point;
	}
	
	public void functionTruc() {
		this.point = 0;
		int point = 0;
	}

	@Override
	public String toString() {
		return "Cell [position=" + position + ", point=" + point + "]";
	}
	
	

}
