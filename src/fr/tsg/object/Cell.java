package fr.tsg.object;

import java.util.HashMap;
import java.util.Map;

public class Cell {

    Position position;
    int point;
    Token pion;

    public Cell(int x, int y, int point) {
        this.position = new Position(x, y);
        this.point = point;
        this.pion = null;
    }

    public boolean isAvailable() {
        // je mets un return, sinon ça ne compile pas
        boolean available = true;
        return available;
    }

    public void removeAPion() {
        /*
         * est necessaire a chaque fois qu'un pion est déplacé, il doit etre supprimé de
         * son emplacement initiale
         */

    }

    public void placeAPion() {
        /*
         * est necessaire a chaque fois q'un pion est deplacé, apères avoir été
         * supprimé, il doit être positionné a un endroit différent du précédent, tout
         * en ne chevauchant pas un autre pion.
         */

    }

    @Override
    public String toString() {
        return "Cell [position=" + position.toString() + ", point=" + point + "]";
    }

    public Map<Integer, String> afficherCell(boolean choices, Plateau plateau, Token pion) {
        if (choices) {
            return afficherWithChoiceCell(plateau, pion);
        } else {
            return afficherCellWithoutChoice();
        }
    }

    private Map<Integer, String> afficherCellWithoutChoice() {
        Map<Integer, String> toDraw = new HashMap<Integer, String>();
        if (position.y == 0) {
            toDraw.put(0, "* * * * *");
        }
        toDraw.put(1, "*       *");
        if (this.pion != null) {
            toDraw.put(2, "*   " + this.pion.couleur.substring(0, 1) + "   *");

        } else if (this.point > 0) {
            toDraw.put(2, "*   0   *");
        } else {
            toDraw.put(2, "*       *");
        }
        toDraw.put(3, "*       *");
        toDraw.put(4, "* * * * *");

        return toDraw;
    }

    /**
     * @param plateau
     * @param pion
     * @return
     */
    private Map<Integer, String> afficherWithChoiceCell(Plateau plateau, Token pion) {
        Map<Integer, String> toDraw = new HashMap<Integer, String>();
        if (position.y == 0) {
            toDraw.put(0, "X X X X X");
        }
        toDraw.put(1, "*       *");
        if (this.pion != null) {
            toDraw.put(2, "*   " + this.pion.couleur.substring(0, 1) + "   *");
        } else if (this.point > 0) {
            toDraw.put(2, "*   0   *");
        } else {
            toDraw.put(2, "*       *");
        }

        Token pionTempH = new Token(pion.couleur);
        pionTempH.vertical = false;
        pionTempH.attributSecondPosition(plateau, this.position);
        Token pionTempV = new Token(pion.couleur);
        pionTempV.vertical = true;
        pionTempV.attributSecondPosition(plateau, this.position);

        String choiceToWrite = testPionTemp(plateau, pionTempV);
        String secondChoice = testPionTemp(plateau, pionTempH);

        if (!choiceToWrite.isBlank() && !secondChoice.isBlank()) {
            choiceToWrite = choiceToWrite + "-" + secondChoice;
        } else if (!secondChoice.isBlank()) {
            choiceToWrite = secondChoice;
        }
        int longueurChoice = choiceToWrite.length();
        int nbSpace = 7-longueurChoice;
        String ligne3 = new String("*");
        for (int i = 0; i < nbSpace; i++){
            ligne3+=" ";
        }
        ligne3+=choiceToWrite;
        ligne3+="*";
        toDraw.put(3, ligne3);



        toDraw.put(4, "* * * * *");

        return toDraw;
    }

    private String testPionTemp(Plateau plateau, Token pionATester) {
        String choiceToReturn = "";
        if (GameUtils.checkIfMoveIsValid(pionATester, position, plateau)) {
            Game.choises.put(Game.lastChoice, pionATester);
            choiceToReturn = String.valueOf(Game.lastChoice);
            Game.lastChoice++;
        }
        return choiceToReturn;
    }
}
