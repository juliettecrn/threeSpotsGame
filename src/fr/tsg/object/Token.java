package fr.tsg.object;

public class Token {
	Cell cell1;
	Cell cell2;
	boolean vertical = false;
	String couleur;

	public Token(String couleur) {
		/*
		 * element qui a une positions qui occupe 2 cellules Constructeur
		 */
		this.couleur = couleur;

	}

	public int countPointAfterMove() {
		/*
		 * Depuis la condition qui permet de dire si une ou les deux cases recouvertes
		 * par un pion, sont des cases sur la troisième colonne, ajouter ou non des
		 * points au score du joueur
		 */
		return 0;
	}

	public void reset() {
		this.cell1.pion = null;
		this.cell1 = null;
		this.cell2.pion = null;
		this.cell2 = null;
	}

	
	public void moveTo(Position destination, Plateau plateau) {
		this.cell1 = plateau.getCellAtCoordinates(destination);
		Position destination2 = getSecondPosition(destination);
		this.cell2 = plateau.getCellAtCoordinates(destination2);
		this.cell1.pion = this;
		this.cell2.pion = this;
	}

	public int compterPoint(){
		int value = 0;
		value = cell1.point + cell2.point;
		return value;
		
	}
	public Position getSecondPosition(Position firstPosition) {
		Position position2 = new Position();
		if (this.vertical) {
			position2.y = firstPosition.y - 1;
			position2.x = firstPosition.x;
		} else {
			position2.x = firstPosition.x + 1;
			position2.y = firstPosition.y;
		}
		return position2;
	}

}
