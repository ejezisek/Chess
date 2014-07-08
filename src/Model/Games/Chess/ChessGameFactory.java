package Model.Games.Chess;

import Model.Games.AbstractGameFactory;
import Model.Games.Game;
import Model.Games.placement.PiecePlacement;

public class ChessGameFactory implements AbstractGameFactory {
	/**
	 * Instantiates a new chess game.  Places the pieces at their respective squares.
	 * @throws InstantiationException 
	 */
	@Override
	public Game createGame(PiecePlacement placement) throws InstantiationException {
		// TODO Auto-generated method stub
		return new ChessGame(placement);
	}
}