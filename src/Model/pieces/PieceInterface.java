package Model.pieces;
import java.util.ArrayList;

import Model.position;
import Model.Games.Player;

public interface PieceInterface {
	public abstract ArrayList<position> getAttacks(); 
	public abstract ArrayList<position> getMovements(); 
	public abstract boolean canMove(position to);
	public abstract position getPosition();
	public abstract void Move(position to);
	public abstract Player getPlayer();
	public abstract String getText();
}
