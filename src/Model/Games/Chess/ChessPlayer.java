package Model.Games.Chess;

import Model.Games.Player;

public class ChessPlayer implements Player {

	/**
	 * Creates a new chess player.  The values for the player can only be zero or one.
	 * @param playerNum
	 * @throws InstantiationException
	 */
	public ChessPlayer(int playerNum) throws InstantiationException
	{
		this.playerNum=playerNum;
		switch(playerNum)
		{
		case 0:
			rowNum=0;
			pawnRow=1;
			break;
		case 1:
			rowNum=7;
			pawnRow=6;
			break;
		default:
			throw new InstantiationException();
		}
	}
	
	@Override
	public void setActive() {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectedItem() {
		// TODO Auto-generated method stub

	}
	public int getPawnRow()
	{
		return pawnRow;
	}
	public int getRowNum()
	{
		return rowNum;
	}
	
	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public int getPlayerNum() {
		// TODO Auto-generated method stub
		return playerNum ;
	}
	
	private int rowNum;
	private int playerNum;
	private int pawnRow;
	private final int width=8;
	private final int height = 8;
	
	@Override
	public int moveUp() {
		// TODO Auto-generated method stub
		switch(playerNum)
		{
		case 0:
			return 1;
		case 1:
			return -1;
		}
		return 0;
	}
}
