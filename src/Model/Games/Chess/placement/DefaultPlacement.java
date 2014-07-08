package Model.Games.Chess.placement;

import java.util.ArrayList;
import java.util.List;

import Model.position;
import Model.Games.Chess.ChessPlayer;
import Model.Games.placement.PiecePlacement;

public class DefaultPlacement implements PiecePlacement {

	@Override
	public List<position> getPawnPositions(ChessPlayer player) {
		// TODO Auto-generated method stub
		List<position> pawnPositions=new ArrayList<position>();
		for(int i=0; i<player.getWidth(); i++)
		{
			position pos=new position();
			pos.x=i;
			pos.y=player.getPawnRow();
			pawnPositions.add(pos);
		}
		return pawnPositions;
	}

	private static List<position> addIthPosition(int [] ithPositions, ChessPlayer player)
	{
		List<position> positionList=new ArrayList<position>();
		for(int val : ithPositions)
		{
			position pos=new position();
			pos.x=val;
			pos.y=player.getRowNum();
			positionList.add(pos);
		}
		return positionList;
	}
	
	@Override
	public List<position> getKnightPositions(ChessPlayer player) {
		// TODO Auto-generated method stub
		return addIthPosition(new int[] {1,6}, player);
	}

	@Override
	public List<position> getRookPositions(ChessPlayer player) {
		// TODO Auto-generated method stub
		return addIthPosition(new int[] {0,7}, player);
	}

	@Override
	public List<position> getBishopPositions(ChessPlayer player) {
		// TODO Auto-generated method stub
		return addIthPosition(new int[]{2,5}, player);
	}

	@Override
	public List<position> getKingPosition(ChessPlayer player) {
		// TODO Auto-generated method stub

		return addIthPosition(new int[]{4}, player);
	}

	@Override
	public List<position> getQueenPositions(ChessPlayer player) {
		// TODO Auto-generated method stub
		return addIthPosition(new int[]{3}, player);
	}


}
