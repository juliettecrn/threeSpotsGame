package fr.tsg.object;

import java.util.HashMap;
import java.util.Map;

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
		return "Cell [position=" + position.toString() + ", point=" + point + "]";
	}



	public Map<Integer, String> afficherCell() {
		Map<Integer, String> toDraw = new HashMap<Integer, String>();
		if(position.y == 0) {
			toDraw.put(0, "* * * * *");
		}
		toDraw.put(1, "*       *");
		if(this.pion != null) {
			toDraw.put(2, "*   "
		+this.pion.couleur.substring(0,1)
		+ "   *");
		}else if(this.point > 0) {
			toDraw.put(2, "*   0   *");
		}else {
			toDraw.put(2, "*       *");
		}
		toDraw.put(3, "*       *");
		toDraw.put(4, "* * * * *");

		return toDraw;
	}


}
