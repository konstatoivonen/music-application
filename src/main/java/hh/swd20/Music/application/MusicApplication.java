package hh.swd20.Music.application;

import org.springframework.boot.CommandLineRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Music.application.domain.Genre;
import hh.swd20.Music.application.domain.GenreRepository;
import hh.swd20.Music.application.domain.Song;
import hh.swd20.Music.application.domain.SongRepository;
import hh.swd20.Music.application.domain.User;
import hh.swd20.Music.application.domain.UserRepository;


@SpringBootApplication
public class MusicApplication {
	
	private static final Logger log = LoggerFactory.getLogger(MusicApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MusicApplication.class, args);
	}
	
@Bean
public CommandLineRunner songDemo(SongRepository songRepository, GenreRepository genreRepository, UserRepository userRepository) {
	return (args) -> {
		
		log.info("Testing adding genres");
		genreRepository.save(new Genre("Hardcore"));
		genreRepository.save(new Genre("Post-Hardcore"));
		genreRepository.save(new Genre("Metalcore"));
		genreRepository.save(new Genre("Blackmetal"));
		genreRepository.save(new Genre("Deathmetal"));
		genreRepository.save(new Genre("Punk"));
		genreRepository.save(new Genre("Dance"));
		genreRepository.save(new Genre("Hiphop"));
		genreRepository.save(new Genre("Pop"));
		
		log.info("Testing adding songs");
		songRepository.save(new Song("Thank God", "Counterparts", "The Current Will Carry Us", 2011, genreRepository.findByName("Hardcore").get(0)));
		songRepository.save(new Song("Hate of All Hatreds", "Deicide", "Till Death Do Us Part", 2008, genreRepository.findByName("Deathmetal").get(0)));
		songRepository.save(new Song("Down and Out", "Adept", "Sleepless", 2016, genreRepository.findByName("Post-Hardcore").get(0)));
		songRepository.save(new Song("Freezing Moon", "Mayhem", "De Mysteriis Dom Sathanas", 1994, genreRepository.findByName("Blackmetal").get(0)));
		
		log.info("fetch all songs");
		for (Song song : songRepository.findAll()) {
			log.info(song.toString());
		}
		
		User user1 = new User("user", "$2a$10$qBepAmt6i9ZWjoWuuiQI1eH6MsMKgPRHQjuUXqYU5CCHr.Ik3.0bC", "USER");
		User user2 = new User("admin", "$2a$10$wJTcqkU0a5CWtbZJbHbWr.9/evo/OHICOEBXY.vTVVQoeoi0iSVyG", "ADMIN");
		userRepository.save(user1);
		userRepository.save(user2);
	};
}

}
