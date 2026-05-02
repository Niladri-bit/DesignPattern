package observers;


public interface Observable {

	void register(ChatObserver chatObserver);
	void remove(ChatObserver chatObserver);
}
