package fr.tsg.object;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
	public List<Cell> cellList;
	public static String nomVar = "Test";
	int nbCol = 3;
	int nbRow = 3;

	public void ajouterCell() {
		int point = 0;
		for (int x = 0; x < nbCol; x++) {
			for (int y = 0; y < nbRow; y++) {
				if (x == 2) {
					point += 1;
				}
				Cell cell = new Cell(x, y, point);
				cellList.add(cell);
			}
		}
	}

	public Plateau() {
		this.cellList = new ArrayList<Cell>();
		ajouterCell();
	}

}
