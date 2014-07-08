package Model.Games;

public interface Player {
	abstract void setActive();
	abstract void selectedItem();
	abstract int getWidth();
	abstract int getHeight();
	abstract int moveUp();
	abstract int getPlayerNum();
}
