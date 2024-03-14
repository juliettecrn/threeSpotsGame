package fr.tsg.main;

import java.util.List;
import java.util.Map;
import java.util.Set;

import fr.tsg.object.Cell;
import fr.tsg.object.Game;
import fr.tsg.object.Plateau;

public class Launcher {

	public static void main(String[] args) {
		Game gameInstance = new Game();
		Plateau plateau = gameInstance.plateau;
		//	List<Cell> cells = plateau.cellList;
		//	for(int i=0; i<cells.size(); i++) {
		//		Cell cell = cells.get(i);
		//		System.out.println(cell);
		//	}
		gameInstance.startGame();
		//		System.out.println(gameInstance.winner);

		//Player p = new Player(0, null);

		//p.x = 1;

	}

}
