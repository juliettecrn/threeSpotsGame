package fr.tsg.object;

import java.util.HashMap;
import java.util.Map;

public class Cell {

	Position position;
	int point;
	Token pion;
	Plateau plateau;

	public Cell(int x, int y, int point) {
		this.position = new Position(x, y);
		this.point = point;
		this.pion = null;
	}

	public boolean isAvailable() {
		// je mets un return, sinon ça ne compile pas
		boolean available = true;
		return available;
	}

	public void removeAPion() {
		/*
		 * est necessaire a chaque fois qu'un pion est déplacé, il doit etre supprimé de
		 * son emplacement initiale
		 */

	}

	public void placeAPion() {
		/*
		 * est necessaire a chaque fois q'un pion est deplacé, apères avoir été
		 * supprimé, il doit être positionné a un endroit différent du précédent, tout
		 * en ne chevauchant pas un autre pion.
		 */

	}

	@Override
	public String toString() {
		return "Cell [position=" + position.toString() + ", point=" + point + "]";
	}

	public Map<Integer, String> afficherCell(boolean choices) {
		if(choices) {
			return afficherWithChoiceCell(null);
		}else {
			return afficherCellWithoutChoice();
		}
	}
	private Map<Integer, String> afficherCellWithoutChoice() {
		Map<Integer, String> toDraw = new HashMap<Integer, String>();
		if (position.y == 0) {
			toDraw.put(0, "* * * * *");
		}
		toDraw.put(1, "*       *");
		if (this.pion != null) {
			toDraw.put(2, "*   " + this.pion.couleur.substring(0, 1) + "   *");

		} else if (this.point > 0) {
			toDraw.put(2, "*   0   *");
		} else {
			toDraw.put(2, "*       *");
		}
		toDraw.put(3, "*       *");
		toDraw.put(4, "* * * * *");

		return toDraw;
	}


	private Map<Integer, String> afficherWithChoiceCell(Player player) {
		Map<Integer, String> toDraw = new HashMap<Integer, String>();
		if (position.y == 0) {
			toDraw.put(0, "X X X X X");
		}
		toDraw.put(1, "*       *");
		if (this.pion != null) {
			toDraw.put(2, "*   " + this.pion.couleur.substring(0, 1) + "   *");

		} else if (this.point > 0) {
			toDraw.put(2, "*   0   *");
		} else {
			toDraw.put(2, "*       *");
		}
		Token newPion = new Token("temp");
		newPion.vertical = false;
		newPion.cell1= this;
		//newPion.cell2= this;// mais la dcp c'est la meme cellule??

		if(player.checkIfMoveIsValid(pion, position, plateau)){// j'ai mis un plateau en static  
			String choice= String.valueOf(Game.lastChoice);
			Game.choises.put(Game.lastChoice, newPion);
			Game.lastChoice++;
			toDraw.put(3, "*  "+ choice+"   ");
			Position position2 = pion.getSecondPosition(position);
			newPion.cell2 = plateau.getCellAtCoordinates(position2);

			
			
		}
		toDraw.put(3, "*       *");
		toDraw.put(4, "* * * * *");

		return toDraw;
	}
	
	
}
