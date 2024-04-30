package Strategy;

import Model.Board;
import Model.Cell;
import Model.Move;

import java.util.HashMap;

public class WinningStrategy {
    HashMap<Integer, HashMap<Character, Integer>> rowMaps = new HashMap<>();
    HashMap<Integer, HashMap<Character, Integer>> colMaps = new HashMap<>();
    HashMap<Character, Integer> leftDiagonalMap = new HashMap<>();
    HashMap<Character, Integer> rightDiagonalMap = new HashMap<>();

    public boolean checkWinner(Board board, Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        char character = move.getPlayer().getSymbol().getCharacter();

        // Checks Rows
        if(!rowMaps.containsKey(row)) {
            rowMaps.put(row, new HashMap<>());
        }
        HashMap<Character,Integer> curRowMap = rowMaps.get(row);
        if(!curRowMap.containsKey(character)){
            curRowMap.put(character,1);
        }
        else{
            curRowMap.put(character,curRowMap.get(character)+1);
        }
        if(curRowMap.get(character) == board.getSize()) return true;

        // Checks Cols
        if(!colMaps.containsKey(col)) {
            colMaps.put(col, new HashMap<>());
        }
        HashMap<Character,Integer> curColMap = colMaps.get(col);
        if(!curColMap.containsKey(character)){
            curColMap.put(character,1);
        }
        else{
            curColMap.put(character,curColMap.get(character)+1);
        }
        if(curColMap.get(character) == board.getSize()) return true;

        //Left Diagonal
        if(row == col) {
            if(!leftDiagonalMap.containsKey(character)){
                leftDiagonalMap.put(character,1);
            }
            else leftDiagonalMap.put(character,leftDiagonalMap.get(character)+1);
            if(leftDiagonalMap.get(character)==board.getSize()) return true;
        }

        //Right Diagonal
        if(row+col == board.getSize()-1) {
            if(!rightDiagonalMap.containsKey(character)){
                rightDiagonalMap.put(character,1);
            }
            else rightDiagonalMap.put(character,rightDiagonalMap.get(character)+1);
            if(rightDiagonalMap.get(character)==board.getSize()) return true;
        }

        return false;
    }
}
