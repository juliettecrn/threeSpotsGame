package fr.tsg.object;

import java.util.Random;

public class Player {
	public Token pion;
	int points;

	// constructor
	public Player(int points) {
		this.points = points;
	}

	public void play(Plateau plateau) {
		// choisi ta destination, bouge pion, recupère poins,
		chooseDestination(plateau);
		movePion(pion);
	}

	public void movePion(Token pion) {

	}

	// une fonction privé (private) est une fonction qui a une portée limitée à la
	// classe.
	// cela veut dire que tu ne pourras appeler cette fonction que depuis cette
	// classe, il faut trouvver où ;)
	private Position chooseDestination(Plateau plateau) {
		Position position = null;
		do {
			position = getRandomDestination();
		} while (!checkIfMoveIsValid(position,plateau));

		return position;
	}

	private boolean checkIfMoveIsValid(Position position,Plateau plateau) {
		/*
		 * Il y a deux conditions, il faut verifier si le pion a réellement une position
		 * différente, ainsi que le fait qu'il n'y ai pas d'autres pièces a l'endroit où
		 * nous voulons la decaller
		 */
		Position position2 = new Position();
		boolean valid = true;
		//verifie que le pion est sur le plateau
		if (pion.vertical) {
			if (position.y == 0) {
				valid = false;
			}
		} else {
			if (position.x == Plateau.NB_COL - 1) {
				valid = false;
			}
		}
		//on verifie que le pion a bougé (occupe des positions/cell différentes)
		if (valid) {
			
			if (pion.vertical) {
				position2.y = position.y + 1;
				position2.x = position.x;
			} else {
				position2.x = position.x + 1;
				position2.y = position.y;
			}
			if (pion.cell1.position.x == position.x && pion.cell1.position.y == position.y) {
				if (pion.cell2.position.x == position2.x && pion.cell2.position.y == position.y) {
					valid = false;
				}
			}

		}
		//verifier que la cellule n'est pas occupé
		if (valid) {
			Cell cell1 = plateau.getCellAtCoordinates(position);
			Cell cell2 = plateau.getCellAtCoordinates(position2);
			if(cell1.pion != null || cell1.pion != this.pion) {
				valid = false;
			}else if (cell2.pion != null || cell2.pion != this.pion){
				valid = false;
			}
			
		}
		return valid;
	}

	private Position getRandomDestination() {

		Random rand = new Random();
		int x = rand.nextInt(Plateau.NB_COL);
		int y = rand.nextInt(Plateau.NB_ROW);
		int verticaly = rand.nextInt(2);
		if (verticaly == 0) {
			this.pion.vertical = false;
		} else {
			this.pion.vertical = true;
		}
		Position destination = new Position(x, y);

		return destination;
	}

	// getter && setter
	public Token getPion() {
		return pion;
	}

	public void setPion(Token pion) {
		this.pion = pion;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}
