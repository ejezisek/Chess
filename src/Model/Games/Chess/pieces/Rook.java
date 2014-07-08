package Model.Games.Chess.pieces;

import java.util.ArrayList;

import Model.position;
import Model.Games.Game;
import Model.Games.Player;
import Model.pieces.PieceInterface;

public class Rook implements PieceInterface {

	private Player player;


	public Rook(Player player, position pos, Game game)
	{
		this.player=player;
	}
	
	@Override
	public ArrayList<position> getAttacks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<position> getMovements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Move(position to) {
		// TODO Auto-generated method stub

	}



	@Override
	public Player getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return "Rk";
	}

	@Override
	public boolean canMove(position to) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public position getPosition() {
		// TODO Auto-generated method stub
		return null;
	}
}
