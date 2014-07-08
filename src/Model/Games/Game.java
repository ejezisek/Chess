package Model.Games;

import java.util.List;

import javax.management.InvalidAttributeValueException;

import Model.position;
import Model.Games.Chess.cantMoveException;
import Model.pieces.PieceInterface;

public interface Game {
	public abstract PieceInterface[][] getBoard();
	public abstract int getWidth();
	public abstract int getHeight();
	public abstract void Move(position from, position to) throws cantMoveException;
	public abstract void Move(String from, String to) throws cantMoveException, InvalidAttributeValueException;
	public abstract List<Move> getMoveList();
	public abstract PieceInterface getPosition(position placement);
	public abstract void delete(position pos);
}
