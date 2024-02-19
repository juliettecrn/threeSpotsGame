package fr.tsg.object;

public class Game {

//	public Player player1 = new Player(0);
//	public Player player2 = new Player(0);
//	public Plateau plateau = new Plateau();
	

	public Player player1;
	public Player player2;
	public Plateau plateau;
	
	public Game() {
		this.player1 = new Player(0);
		this.player2 = new Player(0);
		this.plateau = new Plateau();
	}
	
}
