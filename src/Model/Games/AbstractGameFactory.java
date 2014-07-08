package Model.Games;

import Model.Games.placement.PiecePlacement;


/**
 * This is using the abstract factory design pattern.
 * The idea is to create different game objects dependent on the gameFactory object.
 * @author Genesis
 */
public interface AbstractGameFactory {
	public abstract Game createGame(PiecePlacement piece) throws InstantiationException ;
}