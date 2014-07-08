package Main;

import javax.management.InvalidAttributeValueException;

import Model.Games.AbstractGameFactory;
import Model.Games.Game;
import Model.Games.Chess.ChessGameFactory;
import Model.Games.Chess.cantMoveException;
import Model.Games.Chess.placement.DefaultPlacement;
import display.Display;
import display.chess.text.TextDisplay;

public class Main {

	public static void main(String[] args) throws InstantiationException, cantMoveException, InvalidAttributeValueException {
		// TODO Auto-generated method stub
		Display gameDisplay=new TextDisplay();
		AbstractGameFactory gameFact=new ChessGameFactory();
		Game game=gameFact.createGame(new DefaultPlacement());
		game.Move("E2", "E3");
		game.Move("E7", "E5");
		game.Move("F2", "F4");
		game.Move("E5", "E4");
		game.Move("D2", "D4");
		game.Move("E4", "D3");
		/*
		PieceCreator bob=new PieceCreator()
		{

			@Override
			public PieceInterface Create(Player player, position startPos,
					Game game) {
				// TODO Auto-generated method stub
				return null;
			}
			
		};*/
		gameDisplay.disp(game);
	}
}
