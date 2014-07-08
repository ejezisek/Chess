package Model.Games.Chess.pieces;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import Model.position;
import Model.Games.Game;
import Model.Games.Move;
import Model.Games.Player;
import Model.Games.Chess.ChessGame;
import Model.pieces.PieceInterface;

public class Pawn implements PieceInterface {

	public Pawn(Player player, position startPos, Game game)
	{
		this.player=player;
		this.pos=startPos;
		this.game=game;
	}
	
	private boolean canAttack(position pos, PieceInterface[][] board)
	{
		if(board[pos.x][pos.y]==null)
			return false;
		if(board[pos.x][pos.y].getPlayer()==null)
			return false;
		return !board[pos.x][pos.y].getPlayer().equals(this.getPlayer());
	}
	
	private boolean enPassant(position pos)
	{
		//Check to see if the last move the pawn moved past the available square
		//If no moves have happened yet, return false.
		if(game.getMoveList()==null || game.getMoveList().isEmpty())
			return false;
		//Gets the last move.
		Move move=game.getMoveList().get(game.getMoveList().size()-1);
		if(move.getType() instanceof Pawn)
		{
			//Ensure that the previous pawn moved two places.
			if(Math.abs(move.getPrev().y-move.getNew().y)==2)
			{
				//Check that the y position is in the correct spot.
				if((pos.y-this.player.moveUp())==move.getNew().y)
				{
					//Check that the x position is in the correct spot
					if(pos.x==move.getNew().x)
						return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public ArrayList<position> getAttacks() {
		// TODO Auto-generated method stub
		ArrayList<position> possibleAttacks=new ArrayList<position>();
		PieceInterface[][] board=game.getBoard();
		position move;

		//If the pawn ever reaches the end of the board, it should promote.  Therefore incrementing or decrementing the pawn should never be greater than 7 or less than zero.
		if(pos.y<=0 || pos.y>=7)
		{
			throw new InvalidParameterException();
		}
		if(pos.x+1<=7)
		{
			move = new position();
			move.x=pos.x+1;
			move.y=pos.y+player.moveUp();
			if(canAttack(move, board) || enPassant(move))
			{
				possibleAttacks.add(move);
			}
		}
		if(pos.x-1>=0)
		{
			move = new position();
			move.x=pos.x-1;
			move.y=pos.y+player.moveUp();
			if(canAttack(move, board) || enPassant(move))
			{
				possibleAttacks.add(move);
			}
		}
		return possibleAttacks;
	}

	
	
	@Override
	public ArrayList<position> getMovements() {
		ArrayList<position> possibleMovements=new ArrayList<position>();
		
		position move;
		PieceInterface [][] board=game.getBoard();
		if(!hasMoved )
		{
			//We must ask the game if we can move to our location plus two up.
			move=new position();
			move.x=pos.x;
			move.y=pos.y+2*player.moveUp();
			if(board[move.x][move.y]==null)
				possibleMovements.add(move);
		}
		move=new position();

		move.x=pos.x;
		move.y=pos.y+player.moveUp();
		
		if(board[move.x][move.y]==null)
			possibleMovements.add(move);
		return possibleMovements;
	}
	
	public final boolean canMove(position to)
	{
		for(position pos : getMovements())
		{
			if(pos.x==to.x && pos.y==to.y)
				return true;
		}
		for(position pos:getAttacks())
		{
			if(pos.x==to.x && pos.y==to.y)
				return true;
		}
		return false;
	}
	
	@Override
	public final void Move(position to) {
		// TODO Auto-generated method stub
		hasMoved=true;
		this.pos=to;

		if(this.enPassant(to))
		{
			Move lastMove=game.getMoveList().get(game.getMoveList().size()-1);
			position pos=lastMove.getNew();
			game.delete(pos);
		}
		if(to.y+this.getPlayer().moveUp()>7||to.y+this.getPlayer().moveUp()<0)
		{
			((ChessGame)game).promote(this);
		}
	}

	

	@Override
	public Player getPlayer() {
		return player;
	}
	
	private Player player;

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return "Pa";
	}
	private boolean hasMoved=false;
	private position pos;
	private Game game;

	@Override
	public position getPosition() {
		// TODO Auto-generated method stub
		return null;
	}
}
