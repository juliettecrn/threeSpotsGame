package fr.tsg.object;

import java.util.Random;

public class Player {
	public Token pion;
	int score;

	// constructor
	public Player(int points) {
		this.score = points;

	}

	public void play(Token pionBlanc, Plateau plateau) {
		playPion(this.pion, plateau, true);
		playPion(pionBlanc, plateau, false);
	}
	public void playPion(Token pion, Plateau plateau, boolean scoring) {
		Position destination = chooseDestination(pion, plateau);
		movePion(pion, destination, plateau, scoring);
	}
	public void movePion(Token pion, Position destination, Plateau plateau, boolean scoring) {

		pion.reset();
		pion.moveTo(destination, plateau);
		if (scoring) {
			compterPoints();
		}
	}

	// une fonction privé (private) est une fonction qui a une portée limitée à la
	// classe.
	// cela veut dire que tu ne pourras appeler cette fonction que depuis cette
	// classe, il faut trouvver où ;)
	private Position chooseDestination(Token pion, Plateau plateau) {
		Position position = null;
		do {
			position = getRandomDestination();
			// String direction = this.pion.vertical ? "vertical": "horizontal";// ca j'ai
			// pas compris
			// System.out.println(position.x + "," + position.y + " " + direction );
		} while (!GameUtils.checkIfMoveIsValid(pion, position, plateau));

		return position;
	}

	public void compterPoints() {
		this.score += pion.compterPoint();
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

	public String toString() {
		return pion.couleur ;
	}

	public void setPion(Token pion) {
		this.pion = pion;
	}

	public int getPoints() {
		return score;
	}

	public void setPoints(int points) {
		this.score = points;
	}

}
