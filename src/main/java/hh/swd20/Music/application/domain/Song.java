package hh.swd20.Music.application.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Song {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private String artist;
	private String album;
	private int year;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "genreid")
	private Genre genre;
	
	public Song() {
		
	}
 	
	public Song(String title, String artist, String album, int year, Genre genre) {
		super();
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.year = year;
		this.genre = genre;
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
	
	public Genre getGenre() {
		return genre;
	}
	
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	@Override
	public String toString() {
		if (this.genre != null)
			return "Song [id=" + id + ", title=" + title + ", artist=" + artist + ", album=" + album + ", year=" + year + ", genre=" + this.getGenre() + "]";
		else
			return "Song [id=" + id + ", title=" + title + ", artist=" + artist + ", album=" + album + ", year=" + year + "]";
	
	}
	
	
}
