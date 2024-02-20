package fr.tsg.object;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
    public List<Cell> cellList;
    public List<Pions> pionList;
    int nbCol = 3;
    int nbRow = 3;

    //constructor
    public Plateau() {
        this.cellList = new ArrayList<Cell>();
        initialisationAllCells();
    }

    //class method
    public void initialisationAllCells() {
        int point = 0;
        for (int x = 0; x < nbCol; x++) {
            for (int y = 0; y < nbRow; y++) {
            	initOneCell(x, y);
            }
        }
    }

    public void initialisationAllPions() {
    	 /*Les pions rouge et bleu sont pas de joueurs definis, au debut du jeu ils n'appartiennent a personne. Cependant
    	  *le pion neutre est différent car il ne peut pas etre le pion d'un joueur
         */
    }


    public void initialisationOnePion() {
    	
    }
    
    public void initOneCell(int x, int y) {
    	int point = 0;
    	
    	if (x == 2) {
            point += 1;
        }
        Cell cell = new Cell(x, y, point);
        cellList.add(cell);   	
    }
}

