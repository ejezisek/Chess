package Model.Games.Chess.pieces;

import Model.position;
import Model.Games.Game;
import Model.Games.Player;
import Model.pieces.PieceInterface;

public interface PieceCreator {
	PieceInterface Create(Player player, position startPos, Game game);
}
