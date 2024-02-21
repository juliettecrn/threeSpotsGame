package fr.tsg.object;

public class Game {

//	public Player player1 = new Player(0);
//	public Player player2 = new Player(0);
//	public Plateau plateau = new Plateau();

	int turn = 1;
	public Player playerR;
	public Player playerB;
	public Plateau plateau;
	Token pionBlanc;


	//Constructor
	public Game() {
		initGame();

		
	}

	//Class method
	public void startGame(){
		/* Le plateau, les score, le choix des couleurs doivent etre initialisé, le jeu doit afficher le plateau, proposer aux 
		 * joueurs de commencer une parti, de choisir leur couleur */
		initGame();
		initAllPions();
		do {
			System.out.println("Turn " + this.turn);
			startTurn();
		}while (!checkVictoryConditions());
		
	}

	private void startTurn(){
		/* est utilisé à chaque tour, doit afficher le joueur qui doit jouer, les emplacements disponibles ainsi que son score 
		 * Un tour c'est quand tout les joueurs ont joués
		 * */
		playerR.play(this.plateau);
		playerB.play(this.plateau);
		this.turn++;
		//afficher le score
		

	}

	private boolean checkVictoryConditions(){
		/* Verifier si un joueur a 12 points ou plus, si oui verifier le nombre de point de l'adversaire, s'il a 6 ou moins,
		 * c'est celui ci qui gagne, s'il a plus, c'est le joueur a 12 points qui gagne
		 */
		boolean victory = false;
		if (playerR.points >= 12) {
			if (playerB.points >6) {
				victory = true;
			}
		}else if (playerB.points >= 12) {
			if (playerR.points > 6) {
				victory = true;
			}
		}
		if (victory == true) {
			stopGame();
		}
		return victory;
	}

	private void stopGame(){
		/* Afficher le gagnant, et que la partie est fini, tout en ne laissant pas la possibilité de jouer un tour de plus */
		
	}

	public void initAllPions() {
		Token pionRouge = new Token("Rouge");
		Cell cellRouge1 = this.plateau.getCellAtCoordinates(0, 1);
		Cell cellRouge2 = this.plateau.getCellAtCoordinates(0, 2);
		pionRouge.cell1 = cellRouge1;
		pionRouge.cell2 = cellRouge2;
		playerR.pion = pionRouge;
		cellRouge1.pion = pionRouge;
		cellRouge2.pion = pionRouge;
		
		Token pionBleu = new Token("Bleu");
		Cell cellBleu1 = this.plateau.getCellAtCoordinates(1, 1);
		Cell cellBleu2 = this.plateau.getCellAtCoordinates(1, 2);
		pionBleu.cell1 = cellBleu1;
		pionBleu.cell2 = cellBleu2;
		playerB.pion = pionBleu;
		cellBleu1.pion = pionBleu;
		cellBleu2.pion = pionBleu;

		
		this.pionBlanc = new Token("Blanc");
		Cell cellBlanc1 = this.plateau.getCellAtCoordinates(2, 1);
		Cell cellBlanc2 = this.plateau.getCellAtCoordinates(2, 2);
		this.pionBlanc.cell1 = cellBlanc1;
		this.pionBlanc.cell2 = cellBlanc2;
		cellBlanc1.pion = pionBlanc;
		cellBlanc1.pion = pionBlanc;

	}
		public void initGame() {
		this.playerR = new Player(0);
		this.playerB = new Player(0);
		this.plateau = new Plateau();
	}
	
}
