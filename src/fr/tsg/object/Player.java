package fr.tsg.object;

import java.util.List;

public class Player {
	public Pions pion;
	int p;
	int points;

	//constructor
	public Player(int points){
	        this.points = points;
	}

	public void play(){

	}
	public void movePion(Pions pion){

	}
	//une fonction privé (private) est une fonction qui a une portée limitée à la classe.
	//cela veut dire que tu ne pourras appeler cette fonction que depuis cette classe, il faut trouvver où ;)
	private List<Position> chooseDestination(){

		return null;
	}

	private boolean checkIfMoveIsValid(){
		/*Il y a deux conditions, il faut verifier si le pion a réellement une position différente, ainsi que le fait 
		 *qu'il n'y ai pas d'autres pièces a l'endroit où nous voulons la decaller
		*/

		return true;
	}

	private void applyMove(Pions pion, List<Position> move){
		/*depuis une liste de position, déplacer un pion d'un emplacement à un autre */


	}
	//getter && setter
	public int getPoint(){
        return p;
    }

	public Pions getPion() {
		return pion;
	}

	public void setPion(Pions pion) {
		this.pion = pion;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	
}
