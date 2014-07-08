package ObserverSystem;



/**
 * This class implements a publish subscribe system.
 * This allows the chess game to talk to the display and the Control to send information to the chess game.
 * For example when the game is over, the chess game will notify the display.
 * On each move, the control will send data to the chess game telling the game what move was made.
 * @author Genesis
 *
 */
public interface TopicManager {
	public abstract void addTopic(String name, Topic topic);
	public abstract void addSubscriber(String topicName, Subscriber subscriber);
	public abstract void notifySubscribers(String topicName, Object ... data);
}