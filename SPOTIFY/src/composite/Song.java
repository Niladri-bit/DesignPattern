package composite;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import interfaces.Playable;
import observer.Artist;

public class Song implements Playable{
	private final String id;
	private final String title;
	private final Artist artist;
	private final int durationInSeconds;
	
	public Song(String id, String title, Artist artist, int durationInSeconds) {
		super();
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.durationInSeconds = durationInSeconds;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Artist getArtist() {
		return artist;
	}

	public int getDurationInSeconds() {
		return durationInSeconds;
	}

	@Override
	public List<Song> getTracks() {
		return Collections.singletonList(this);
	}
}
