package Model;

import java.util.*;

import Exceptions.InvalidMoveException;
import Model.Enums.CellState;
import Model.Enums.GameState;
import Strategy.WinningStrategy;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
    private Board board;
    private List<Player> playerList;
    private int nextPlayerMoveIndex;
    private GameState gameState;
    private List<Move> moveList;
    private Player winner;
    private static WinningStrategy winningStrategy = new WinningStrategy();

    public Game(int dimension, List<Player> playerList){
        this.board = new Board(dimension);
        this.playerList = playerList;
        this.moveList = new ArrayList<>();
        this.gameState = GameState.ONGOING;
        this.nextPlayerMoveIndex = 0;
    }

    //Own Methods

    public void printBoard() {
        this.board.printBoard();
    }

    public void makeMove() throws InvalidMoveException {
        Player currPlayer = playerList.get(nextPlayerMoveIndex);
        Move move = currPlayer.makeMove(board); //Move the curr Player wants to make
        if(!validateMove(move)) {  // Validate the move
            throw new InvalidMoveException("Invalid move made by "+ currPlayer.getName());
        }

        //Make the move
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Cell cellToChange = board.getBoard().get(row).get(col);
        cellToChange.setPlayer(currPlayer);
        cellToChange.setCellState(CellState.FILLED);

        Move finalMove = new Move(cellToChange,currPlayer); //Final move made by the cur player
        moveList.add(finalMove);
        nextPlayerMoveIndex = (nextPlayerMoveIndex+1) % playerList.size();

        if(winningStrategy.checkWinner(board,finalMove)) {
            gameState = GameState.ENDED;
            winner = currPlayer;
        }
        else if (moveList.size() == board.getSize()*board.getSize()) {
            gameState = GameState.DRAW;
        }
    }

    private boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if(row<0 || row>=board.getSize() || col<0 || col>= board.getSize() || !move.getCell().getCellState().equals(CellState.EMPTY)) return false;
        return board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY);
    }

}
