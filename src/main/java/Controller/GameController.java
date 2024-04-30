package Controller;

import Exceptions.InvalidMoveException;
import Model.Enums.GameState;
import Model.Game;
import Model.Player;

import java.util.List;

public class GameController {
    public Game startGame(int dimension, List<Player> playerList) {
        // TODO
        //if two player have same symbol throw a new Exception
        return new Game(dimension,playerList);
    }
    public void makeMove (Game game) throws InvalidMoveException {
        game.makeMove();
    }
    public GameState checkState (Game game) {
        return game.getGameState();
    }
    public Player getWinner (Game game) {
        return game.getWinner();
    }
    public void printBoard(Game game) {
        game.printBoard();
    }

}
