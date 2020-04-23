package hh.swd20.Music.application;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.Music.application.domain.Genre;
import hh.swd20.Music.application.domain.Song;
import hh.swd20.Music.application.domain.SongRepository;

@RunWith(SpringRunner.class)
@DataJpaTest

class SongRepositoryTest {

	@Autowired
	private SongRepository repository;
	
	@Test
	public void findByTitleShouldReturnSong() {
		List<Song> songs = repository.findByTitle("Thank God");
		
		assertThat(songs).hasSize(1);
		assertThat(songs.get(0).getTitle()).isEqualTo("Thank God");
	}
	
	@Test
	public void createNewSong() {
		Song song = new Song ("Caves", "Chiodos", "Illuminaudio", 2010, new Genre("Screamo"));
		repository.save(song);
		assertThat(song.getId()).isNotNull();
	}

}
