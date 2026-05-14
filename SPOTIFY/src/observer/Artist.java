package observer;

import java.util.ArrayList;
import java.util.List;

import composite.Album;

public class Artist extends ArtistObservable{
	private final String id;
	private final String name;
	private final List<Album> discography = new ArrayList<>();
	
	public Artist(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	public void releaseAlbum(Album album) {
		discography.add(album);
		System.out.println("Artist "+ name +" has released a new album "+album.getTitle());
		notifyObservers(this, album);
	}


	public String getId() {
		return id;
	}


	public String getName() {
		return name;
	}
	
	
	
}
