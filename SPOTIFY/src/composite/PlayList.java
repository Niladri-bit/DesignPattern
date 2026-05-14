package composite;

import java.util.ArrayList;
import java.util.List;

import interfaces.Playable;

public class PlayList implements Playable{
	
	private final String title;
	private final List<Song> tracks = new ArrayList<Song>();

	
	public PlayList(String title) {
		this.title = title;
	}

	public void addTrack(Song song) {
		tracks.add(song);
	}

	@Override
	public List<Song> getTracks() {
		return List.copyOf(tracks);
	}

	public String getTitle() {
		return title;
	}

	
}
