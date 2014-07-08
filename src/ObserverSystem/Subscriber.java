package ObserverSystem;

public interface Subscriber {
	public abstract void Notify(String notifyValue, Object ... value);
}
