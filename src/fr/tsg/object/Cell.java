package fr.tsg.object;

public class Cell {

	Position position;
	int point;
	Token pion;

	public Cell(int x, int y, int point) {
		this.position =  new Position(x, y);
		this.point = point;
		this.pion = null;
	}

	public boolean isAvailable(){
		//je mets un return, sinon ça ne compile pas
		boolean available = true;
		return available;
	}


	public void removeAPion(){
		/* est necessaire a chaque fois qu'un pion est déplacé, il doit etre supprimé de son emplacement initiale */

	}
	public void placeAPion(){
		/* est necessaire a chaque fois q'un pion est deplacé, apères avoir été supprimé, il doit être positionné a un 
		 * endroit différent du précédent, tout en ne chevauchant pas un autre pion.	
		 */
		
	}

	@Override
	public String toString() {
		return "Cell [position=" + position + ", point=" + point + "]";
	}



}
