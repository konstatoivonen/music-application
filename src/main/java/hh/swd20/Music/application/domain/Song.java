package hh.swd20.Music.application.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Song {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private String artist;
	private String album;
	private int year;
	
	public Song() {
		
	}
 	
	public Song(Long id, String title, String artist, String album, int year) {
		super();
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.year = year;
	}

	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Song [id=" + id + ", title=" + title + ", artist=" + artist + ", album=" + album + ", year=" + year + "]";
	}
	
	
}
