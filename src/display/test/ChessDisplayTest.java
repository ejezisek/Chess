package display.test;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Games.AbstractGameFactory;
import Model.Games.Game;
import Model.Games.Chess.ChessGameFactory;
import Model.Games.Chess.placement.DefaultPlacement;
import Model.pieces.PieceInterface;

public class ChessDisplayTest {

	/**
	 * This testing method ensures that the game is set up correctly for the DefaultChess placement.
	 * With respect to the following
	 * Rk Kn Bi Qu Ki Bi Kn Rk 
	 * Pa Pa Pa Pa Pa Pa Pa Pa 
	 * 
	 * 
	 * 
	 * 
	 * Pa Pa Pa Pa Pa Pa Pa Pa 
	 * Rk Kn Bi Qu Ki Bi Kn Rk 
	 * @throws InstantiationException
	 */
	@Test
	public void checkChessSetUp() throws InstantiationException {
		AbstractGameFactory gameFact=new ChessGameFactory();
		Game game=gameFact.createGame(new DefaultPlacement());
		PieceInterface[][] theGame=game.getBoard();
		String vals=new String();
		
		//Ensures that each of the rows displays the correct chess pieces.
		for(int j=0; j<game.getHeight(); j++)
		{
			for(int i=0; i<game.getWidth(); i++)
			{
				if(theGame[i][j]!=null)
					vals+=theGame[i][j].getText()+" ";
			}
			if(j==0 || j==7)
				assertArrayEquals(vals.toCharArray(), "Rk Kn Bi Qu Ki Bi Kn Rk ".toCharArray());
			if(j==1||j==6)
				assertArrayEquals(vals.toCharArray(), "Pa Pa Pa Pa Pa Pa Pa Pa ".toCharArray());
			vals=new String();
		}
	}
	
	/**
	 * This ensures that the pawns are moving correctly.
	 */
	@Test
	public void checkPawnMoveMent()
	{
		
	}

}
