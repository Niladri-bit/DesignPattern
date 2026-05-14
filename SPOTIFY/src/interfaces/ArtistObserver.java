package interfaces;

import composite.Album;
import observer.Artist;

public interface ArtistObserver {
	void update(Artist artist,Album album);
}
