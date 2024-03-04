package fr.tsg.object;

public class GameUtils {
	/**
	 * On verifie si le pion passé en paramètre peut se mettre a la position donné en paramètre
	 * @param pion
	 * @param position
	 * @param plateau
	 * @return
	 */
	public static boolean checkIfMoveIsValid(Token pion, Position position, Plateau plateau) {
		/*
		 * Il y a deux conditions, il faut verifier si le pion a réellement une position
		 * différente, ainsi que le fait qu'il n'y ai pas d'autres pièces a l'endroit où
		 * nous voulons la decaller
		 */
		Position position2 = null;
		boolean valid = true;
		// verifie que le pion est sur le plateau
		if (pion.vertical) {
			if (position.y == 0) {
				valid = false;
			}
		} else {
			if (position.x == Plateau.NB_COL - 1) {
				valid = false;
			}
		}
		// on verifie que le pion a bougé (occupe des positions/cell différentes)
		if (valid) {
			position2 = pion.getSecondPosition(position);
			if (pion.cell1.position.x == position.x && pion.cell1.position.y == position.y) {
				if (pion.cell2.position.x == position2.x && pion.cell2.position.y == position.y) {
					valid = false;
				}
			}

		}
		// verifier que la cellule n'est pas occupé
		if (valid) {
			Cell cell1 = plateau.getCellAtCoordinates(position);
			Cell cell2 = plateau.getCellAtCoordinates(position2);
			if (cell1.pion != null && cell1.pion != pion) {
				valid = false;
			} else if (cell2.pion != null && cell2.pion != pion) {
				valid = false;
			}

		}
		return valid;

	}

}
