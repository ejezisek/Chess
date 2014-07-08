package Model.Games;

import Model.position;
import Model.pieces.PieceInterface;

/**
 * This classed is used to move from one position to the next.  It has to be possible to record the moves as 
 * we want to display the movelist to the player.  We also want to be able to choose how to display the moves using different display formats.
 * @author Genesis
 *
 */
public class Move {
	public Move(position previous, position newPos, PieceInterface type)
	{
		prevPos=previous;
		this.newPos=newPos;
		this.type=type;
	}
	public position getPrev()
	{
		return prevPos;
	}
	public position getNew()
	{
		return newPos;
	}
	public PieceInterface getType()
	{
		return type;
	}
	private PieceInterface type;
	private position prevPos;
	private position newPos;
}
