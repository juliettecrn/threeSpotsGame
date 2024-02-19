package fr.tsg.object;

import java.util.ArrayList;
import java.util.List;

public class Plateau{
	List<Cell> cellList = new ArrayList<Cell>();

	public void ajouterCell() {
		int point=0;
		for(int x = 0; x<3; x++) {
			for (int y = 0; y <3; y++){
				if (x == 2) {
					point +=1;
				}
				Cell cell = new Cell(x, y, point);
				cellList.add(cell);
			}
		}
	}
	

	public Plateau() {

	}

}
