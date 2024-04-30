package Model;

import Model.Enums.BotDifficulty;
import Model.Enums.CellState;
import Model.Enums.PlayerType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Bot extends Player{
    BotDifficulty botDifficulty;

    public Bot(String name, Symbol symbol, PlayerType playerType, BotDifficulty botDifficulty) {
        super(name, symbol, playerType);
        this.botDifficulty = botDifficulty;
    }

    @Override
    public Move makeMove(Board board) {
        // Finds the first empty cell and makes the move there
        for(List<Cell> rowCell : board.getBoard()){
            for(Cell cell : rowCell) {
                if(cell.getCellState().equals(CellState.EMPTY)){
                    return new Move(cell, this);
                }
            }
        }
        return null;
    }
}
