package Model;

import Model.Enums.CellState;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
@Getter
@Setter
public class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(int size) {
        this.size = size;
        board = new ArrayList<>();
        for(int i =0;i<size;i++) {
            board.add(new ArrayList<>());
            for(int j =0; j<size;j++) {
                board.get(i).add(new Cell(i,j));
            }
        }
    }
    public  void printBoard(){
        for (List<Cell> cellRow : board) {
            for (Cell cell : cellRow) {
                if(cell.getCellState().equals(CellState.EMPTY)){
                    System.out.print("| - |");
                }
                else System.out.print("| "+cell.getPlayer().getSymbol().getCharacter() + " |");
            }
            System.out.println();

        }
    }
}
