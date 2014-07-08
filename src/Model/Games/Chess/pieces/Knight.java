package Model.Games.Chess.pieces;

import java.util.ArrayList;

import Model.position;
import Model.Games.Game;
import Model.Games.Player;
import Model.pieces.PieceInterface;

public class Knight implements PieceInterface {

	private Player player;


	public Knight(Player player, position startPos, Game game)
	{
		this.player=player;
		this.pos=startPos;
		this.game=game;
	}
	@Override
	public ArrayList<position> getAttacks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<position> getMovements() {
		//Get all the places that are in the knights movement that he can go to.
		return null;
	}

	@Override
	public void Move(position to) {
		// TODO Auto-generated method stub

	}


	@Override
	public Player getPlayer() {
		// TODO Auto-generated method stub
		return player;
	}
	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return "Kn";
	}
	@Override
	public boolean canMove(position to) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public position getPosition() {
		// TODO Auto-generated method stub
		return pos;
	}

	private position pos;
	private Game game;
}
