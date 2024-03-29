package fr.tsg.object;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
		for (int x = 0; x < NB_COL; x++) {
			for (int y = 0; y < NB_ROW; y++) {
				initOneCell(x, y);
			}
		}
	}
/**
 * plateau de base avec les pions actuels, peut afficher les choix si choices == true, affiche les choix
 * pour le pion passé en paramètre.
 * @param choices
 * @param pion
 * @return
 */
	public Map<Integer, String> afficherPlateau(boolean choices, Token pion) {
		Map<Integer, String> plateauDraw = new HashMap<Integer, String>();
		for(Cell cell : this.cellList) {
			Map<Integer, String> cellDraw = cell.afficherCell(choices, this, pion);
			int start = 4 * cell.position.y;
			Set<Integer> keys = cellDraw.keySet();
			for(Integer lineNumber : keys) {
				String cellLineDraw = cellDraw.get(lineNumber);
				int finalLineNumber = start+lineNumber;
				String finalLineDraw = plateauDraw.getOrDefault(finalLineNumber, "");
				finalLineDraw += cellLineDraw;
				plateauDraw.put(finalLineNumber, finalLineDraw);
			}
		}
		return plateauDraw;
	}
	/**
	 * se fusionne avec afficherPlateau
	 */ 
	public Map<Integer, String> mergeOldMap(Map<Integer,String> oldMap) { 
		Map<Integer, String> newMap = afficherPlateau(false, null);
		String separator = "                      ";
			Set<Integer> keys = newMap.keySet();
			for(Integer lineNumber : keys) {
				String newDraw = newMap.getOrDefault(lineNumber, "");
				String oldDraw = oldMap.getOrDefault(lineNumber, "");
				newDraw = oldDraw + separator + newDraw;
				newMap.put(lineNumber, newDraw);
			}
		return newMap;
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


	public List<Cell> cellLibre(List<Cell> cellList, Token pion){
		List<Cell> deuxiemeList = new ArrayList<Cell>();
		for (int i = 0; i < cellList.size(); i++) {
			Cell cell = cellList.get(i);
			if(cell.pion == null) { 
				deuxiemeList.add(cell);
			}
		}
		return deuxiemeList;
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

