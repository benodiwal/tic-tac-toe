import Controller.GameController;
import Exceptions.InvalidMoveException;
import Model.Bot;
import Model.Enums.BotDifficulty;
import Model.Enums.GameState;
import Model.Enums.PlayerType;
import Model.Game;
import Model.Player;
import Model.Symbol;

import java.security.cert.CRLReason;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws InvalidMoveException {
        GameController gameController = new GameController();
        List<Player> playerList = List.of(
                new Player("Rudra",new Symbol('X'), PlayerType.HUMAN),
                new Player("Kira",new Symbol('O'), PlayerType.BOT)
        );
        Game game = gameController.startGame(3,playerList);

        while(gameController.checkState(game).equals(GameState.ONGOING)){
            //Print the board
            gameController.printBoard(game);
            //Player makes move
            gameController.makeMove(game);
        }
        if(gameController.checkState(game).equals(GameState.DRAW)){
            System.out.println("Game Draw");
        } else if (gameController.checkState(game).equals(GameState.ENDED)) {
            System.out.println("Player " + gameController.getWinner(game).getName()+" is the winner!!" );
        }
    }
}