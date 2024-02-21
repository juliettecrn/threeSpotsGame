package fr.tsg.object;

public class Token {
	Cell cell1;
	Cell cell2;
	boolean vertical = false;
	String couleur;


	public Token(String couleur){
		/*element qui a une positions qui occupe 2 cellules
		 * Constructeur 
		 * */
		this.cell1 = cell1;
		this.cell2 = cell2;
		this.couleur = couleur;

	}
	public int countPointAfterMove(){
		/* Depuis la condition qui permet de dire si une ou les deux cases recouvertes par un pion, sont des cases sur la 
		 * troisième colonne, ajouter ou non des points au score du joueur
		 */
		return 0;
	}
	
}
