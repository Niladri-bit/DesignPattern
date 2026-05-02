package observer;

public interface CartObservable {
	public void addObserver(CartObserver obs);
	public void removeObserver(CartObserver obs);
	public void notifyObservers();
}
