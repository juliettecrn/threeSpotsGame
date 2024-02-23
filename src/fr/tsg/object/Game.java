package fr.tsg.object;

import java.util.Map;
import java.util.Set;

public class Game {

	//	public Player player1 = new Player(0);
	//	public Player player2 = new Player(0);
	//	public Plateau plateau = new Plateau();

	public int turn = 0;
	public Player playerR;
	public Player playerB;
	public Plateau plateau;
	public Token pionBlanc;
	public Player winner;

	// Constructor
	public Game() {
		initGame();
		initAllPions();
	}

	// Class method
	public void startGame() {
		/*
		 * Le plateau, les score, le choix des couleurs doivent etre initialisé, le jeu
		 * doit afficher le plateau, proposer aux joueurs de commencer une parti, de
		 * choisir leur couleur
		 */
		initGame();
		initAllPions();
		do {
			this.turn++;
			startTurn();
		} while (!checkVictoryConditions());
	}

	private void startTurn() {
		/*
		 * est utilisé à chaque tour, doit afficher le joueur qui doit jouer, les
		 * emplacements disponibles ainsi que son score Un tour c'est quand tout les
		 * joueurs ont joués
		 */
		doPlayerTurn(playerB);
		doPlayerTurn(playerR);
	}

	private void doPlayerTurn(Player player) {

		if(!checkVictoryConditions()) {
			Map<Integer, String> oldMap = plateau.afficherPlateau(true);
			player.play(pionBlanc, this.plateau);
			Map<Integer, String> newMap = plateau.mergeOldMap(oldMap);
			printScreen(newMap);
		};
	}

	public void printScreen(Map<Integer, String> map) {
		System.out.println("Turn " + this.turn);
		System.out.println("Player Rouge " + this.playerR.score);
		System.out.println("Player Bleu " + this.playerB.score);
		Set<Integer> keys = map.keySet();
		for (Integer lineNumber : keys) {
			String lineDraw = map.get(lineNumber);
			System.out.println(lineDraw);
		}
	}
	private boolean checkVictoryConditions() {
		/*
		 * Verifier si un joueur a 12 points ou plus, si oui verifier le nombre de point
		 * de l'adversaire, s'il a 6 ou moins, c'est celui ci qui gagne, s'il a plus,
		 * c'est le joueur a 12 points qui gagne
		 */
		boolean victory = false;
		if (playerR.score >= 12 && playerB.score >= 6) {
			victory = true;
			winner = playerR;
		}else if (playerB.score >=12 && playerR.score >= 6) {
			victory = true;
			winner = playerB;
		}else if (playerR.score >= 12 && playerB.score < 6) {
			victory = true;
			winner = playerB;
		}else if (playerB.score >= 12 && playerR.score < 6) {
			victory = true;
			winner = playerR;
		}
		if (victory == true) {
			stopGame();
		}
		return victory;
	}

	private void stopGame() {
		/*
		 * Afficher le gagnant, et que la partie est fini, tout en ne laissant pas la
		 * possibilité de jouer un tour de plus
		 */
		System.out.println("Winner is player " + this.winner.pion.couleur);

	}

	public void initAllPions() {
		Token pionRouge = new Token("RED");
		Cell cellRouge1 = this.plateau.getCellAtCoordinates(1, 0);
		Cell cellRouge2 = this.plateau.getCellAtCoordinates(2, 0);
		pionRouge.cell1 = cellRouge1;
		pionRouge.cell2 = cellRouge2;
		playerR.pion = pionRouge;
		cellRouge1.pion = pionRouge;
		cellRouge2.pion = pionRouge;

		Token pionBleu = new Token("BLUE");
		Cell cellBleu1 = this.plateau.getCellAtCoordinates(1, 1);
		Cell cellBleu2 = this.plateau.getCellAtCoordinates(2, 1);
		pionBleu.cell1 = cellBleu1;
		pionBleu.cell2 = cellBleu2;
		playerB.pion = pionBleu;
		cellBleu1.pion = pionBleu;
		cellBleu2.pion = pionBleu;

		this.pionBlanc = new Token("WHITE");
		Cell cellBlanc1 = this.plateau.getCellAtCoordinates(1, 2);
		Cell cellBlanc2 = this.plateau.getCellAtCoordinates(2, 2);
		this.pionBlanc.cell1 = cellBlanc1;
		this.pionBlanc.cell2 = cellBlanc2;
		cellBlanc1.pion = pionBlanc;
		cellBlanc2.pion = pionBlanc;

	}

	public void initGame() {
		this.playerR = new Player(0);
		this.playerB = new Player(0);
		this.plateau = new Plateau();
		this.winner= null;
	}

	@Override
	public String toString() {
		return "Game [winner=" + winner + "]";
	}

}
