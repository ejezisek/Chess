package Model.Games.placement;

import java.util.List;

import Model.position;
import Model.Games.Chess.ChessPlayer;

public interface PiecePlacement {
	List<position> getPawnPositions(ChessPlayer player);
	List<position> getKnightPositions(ChessPlayer playerNum);
	List<position> getRookPositions(ChessPlayer playerNum);
	List<position> getBishopPositions(ChessPlayer playerNum);
	List<position> getKingPosition(ChessPlayer playerNum);
	List<position> getQueenPositions(ChessPlayer playerNum);
}
