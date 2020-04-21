package hh.swd20.Music.application;

import org.springframework.boot.CommandLineRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Music.application.domain.Song;
import hh.swd20.Music.application.domain.SongRepository;

@SpringBootApplication
public class MusicApplication {
	
	private static final Logger log = LoggerFactory.getLogger(MusicApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MusicApplication.class, args);
	}
	
@Bean
public CommandLineRunner songDemo(SongRepository songRepository) {
	return (args) -> {
		log.info("Testing adding songs");
		songRepository.save(new Song((long) 1, "Thank God", "Counterparts", "The Current Will Carry Us", 2011));
		songRepository.save(new Song((long) 2, "Optimist", "Counterparts", "The Current Will Carry Us", 2011));
		
		log.info("fetch all songs");
		for (Song song : songRepository.findAll()) {
			log.info(song.toString());
		}
	};
}

}
