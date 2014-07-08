package Model.Games.Chess;

import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.List;

import javax.management.InvalidAttributeValueException;

import Model.position;
import Model.Games.Game;
import Model.Games.Move;
import Model.Games.Player;
import Model.Games.Chess.pieces.Bishop;
import Model.Games.Chess.pieces.King;
import Model.Games.Chess.pieces.Knight;
import Model.Games.Chess.pieces.Pawn;
import Model.Games.Chess.pieces.PieceCreator;
import Model.Games.Chess.pieces.Queen;
import Model.Games.Chess.pieces.Rook;
import Model.Games.placement.PiecePlacement;
import Model.pieces.PieceInterface;

public class ChessGame implements Game {

	public ChessGame(PiecePlacement placement) throws InstantiationException
	{
		canPromote=false;
		moves=new ArrayList<Move>();
		board = new PieceInterface[width][height];
		players=new ChessPlayer[2];
		players[0]=new ChessPlayer(0);
		players[1]=new ChessPlayer(1);
		placement.getBishopPositions(players[0]);
		
		//Initialize the pieces to their respective squares.
		for(int i=0; i<2; i++)
		{
			for(position pos : placement.getBishopPositions(players[i]))
			{
				board[pos.x][pos.y]=new Bishop(players[i], pos, this);
			}
			for(position pos : placement.getKingPosition(players[i]))
			{
				board[pos.x][pos.y]=new King(players[i], pos, this);
			}
			for(position pos : placement.getKnightPositions(players[i]))
			{
				board[pos.x][pos.y]=new Knight(players[i], pos, this);
			}
			for(position pos : placement.getRookPositions(players[i]))
			{
				board[pos.x][pos.y]=new Rook(players[i], pos, this);
			} 
			for(position pos : placement.getQueenPositions(players[i]))
			{
				board[pos.x][pos.y]=new Queen(players[i], pos, this);
			}
			for(position pos : placement.getPawnPositions(players[i]))
			{
				board[pos.x][pos.y]=new Pawn(players[i], pos, this);
			}
		}

	}
	
	@Override
	public PieceInterface[][] getBoard() {
		return board;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public List<Move> getMoveList() {
		// TODO Auto-generated method stub
		return moves;
	}
	
	@Override
	public void Move(position from, position to) throws cantMoveException {
		PieceInterface piece=getPosition(from);
		if(piece.canMove(to))
		{
			piece.Move(to);
			moves.add(new Move(from, to, piece));
		}
		else
		{
			throw new cantMoveException();
		}
		//If an en Passant happens kill the correct piece.
		
		//Move the piece to the new location.
		board[from.x][from.y]=null;
		board[to.x][to.y]=piece;
	}
	
	public PieceInterface getPosition(position placement)
	{
		return board[placement.x][placement.y];
	}
	
	public boolean canPromote()
	{
		return canPromote;
	}
	
	@Override
	public void delete(position pos) {
		// TODO Auto-generated method stub
		board[pos.x][pos.y]=null;
	}
	
	public void promoteTo(PieceCreator creator) throws InvalidClassException
	{	
		add(promotion.getPlayer(), promotion.getPosition(), creator);
		promotion=null;
		canPromote=false;
	}
	
	public void promote(Pawn pawn) {
		// TODO Auto-generated method stub
		promotion=pawn;
		canPromote=true;
	}
	
	public void add(Player player, position pos, PieceCreator creator) {
		// TODO Auto-generated method stub
		board[pos.x][pos.y]=creator.Create(player, pos, this);
	}
	
	@Override
	public void Move(String from, String to) throws InvalidAttributeValueException, cantMoveException
	{
		Move(convertTextToPosition(from), convertTextToPosition(to));
	}

	public static position convertTextToPosition(String textVal) throws InvalidAttributeValueException
	{
	char []vals=textVal.toLowerCase().toCharArray();
	position ret=new position();
	if(vals.length>2)
		throw new ArrayIndexOutOfBoundsException();
	if(vals[0]>96 && vals[0]<105)
	{

	}
	else
	{
		throw new InvalidAttributeValueException();
	}
		int columnNum=vals[0]-97;
		int rowNum=Integer.parseInt(new String()+vals[1]);
		ret.x=columnNum;
		ret.y=rowNum-1;
		return ret;
	}
	static final int height=8;
	static final int width=8;
	private PieceInterface[][] board;
	private ChessPlayer[] players;
	private List<Move> moves;
	private PieceInterface promotion;
	private boolean canPromote;
}