package fr.tsg.object;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
	public List<Cell> cellList;
	static int NB_COL = 3;
	static int NB_ROW = 3;

	//constructor
	public Plateau() {
		this.cellList = new ArrayList<Cell>();
		initialisationAllCells();
	}

	//class method
	public void initialisationAllCells() {
		int point = 0;
		for (int x = 0; x < NB_COL; x++) {
			for (int y = 0; y < NB_ROW; y++) {
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
	/**
	 * retourne la cellule qui à la position searchedX, searchedY
	 * @param searchedX
	 * @param searchedY
	 * @return
	 */
	public Cell getCellAtCoordinates(int searchedX, int searchedY) {
		//TODO faire un assert pour vérifier la valeur des paramètres
		for(int i=0; i<cellList.size(); i++){
			Cell cell = cellList.get(i);

			Position positionCell = cell.position;
			if(searchedX == positionCell.x && searchedY == positionCell.y) {
				return cell;
			}
		}
		return null;	
	}


	public Cell getCellAtCoordinates(Position searchedPosition) {
		StringBuffer sb = new StringBuffer();
		return getCellAtCoordinates(searchedPosition.x, searchedPosition.y);
	}


	public List<Cell> getCellAtCoordinates(List<Position> searchedPositions) {
		List<Cell> cellToReturn = new ArrayList<Cell>();
		for(Position pos : searchedPositions) {
			Cell cell = getCellAtCoordinates(pos.x, pos.y);
			cellToReturn.add(cell);
		}
		return cellToReturn;
	}
	public void initOneCell(int x, int y) {
		int point = 0;
		if (x == 2) {
			point += 1;
		}
		Cell cell = new Cell(x, y, point);
		cellList.add(cell);   	
	}

	public List<Cell> getCellList() {
		return cellList;
	}

	public void setCellList(List<Cell> cellList) {
		this.cellList = cellList;
	}

	public int getNbCol() {
		return NB_COL;
	}

	public void setNbCol(int nbCol) {
		this.NB_COL = nbCol;
	}

	public int getNbRow() {
		return NB_ROW;
	}

	public void setNbRow(int nbRow) {
		this.NB_ROW = nbRow;
	}

	//getter && setter

}

