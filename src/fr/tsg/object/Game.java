package fr.tsg.object;

public class Game {

//	public Player player1 = new Player(0);
//	public Player player2 = new Player(0);
//	public Plateau plateau = new Plateau();

	int turn = 1;
	public Player player1;
	public Player player2;
	public Plateau plateau;

	//Constructor
	public Game() {
		this.player1 = new Player(0);
		this.player2 = new Player(0);
		this.plateau = new Plateau();
	}

	//Class method
	public void startGame(){
		/* Le plateau, les score, le choix des couleurs doivent etre initialisé, le jeu doit afficher le plateau, proposer aux 
		 * joueurs de commencer une parti, de choisir leur couleur */

	}

	private void startTurn(){
		/* est utilisé à chaque tour, doit afficher le joueur qui doit jouer, les emplacements disponibles ainsi que son score 
		 * Un tour c'est quand tout les joueurs ont joués
		 * */

	}

	private void checkVictoryConditions(){
		/* Verifier si un joueur a 12 points ou plus, si oui verifier le nombre de point de l'adversaire, s'il a 6 ou moins,
		 * c'est celui ci qui gagne, s'il a plus, c'est le joueur a 12 points qui gagne
		 */
	}

	private void stopGame(){
		/* Afficher le gagnant, et que la partie est fini, tout en ne laissant pas la possibilité de jouer un tour de plus */

	}
}
