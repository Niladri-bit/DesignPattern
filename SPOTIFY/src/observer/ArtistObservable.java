package observer;

import java.util.ArrayList;
import java.util.List;

import composite.Album;
import interfaces.ArtistObserver;

public abstract class ArtistObservable {
	private final List<ArtistObserver> observers = new ArrayList<>();
	
	public void addObserver(ArtistObserver obs) {
		observers.add(obs);
	}
	
	public void removeObserver(ArtistObserver obs) {
		observers.remove(obs);
	}
	
	public void notifyObservers(Artist artist, Album album) {
		for(ArtistObserver obs:observers) {
			obs.update(artist, album);
		}
	}
}
