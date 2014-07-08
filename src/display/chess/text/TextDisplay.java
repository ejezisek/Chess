package display.chess.text;

import Model.Games.Game;
import Model.pieces.PieceInterface;
import display.Display;

public class TextDisplay implements Display{

	@Override
	public void disp(Game game) {
		// TODO Auto-generated method stub
		PieceInterface [] [] vals=game.getBoard();
		for(int i=game.getHeight()-1; i>=0; i--)
		{
			for(int j=0; j<game.getWidth(); j++)
			{
				if(vals[j][i]!=null)
				System.out.print(vals[j][i].getText());
				else
					System.out.print("  ");
				System.out.print(" ");
			}
			System.out.println();
		}
		
	}
	
}
