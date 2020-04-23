package hh.swd20.Music.application.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.Music.application.domain.GenreRepository;
import hh.swd20.Music.application.domain.Song;
import hh.swd20.Music.application.domain.SongRepository;

@Controller
public class SongController {
	@Autowired
	private SongRepository songRepository;
	@Autowired
	private GenreRepository genreRepository;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index() {
		return "redirect:/songlist";
	}
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/songlist", method = RequestMethod.GET)
	public String getSongList(Model model) {
		List<Song> songs = (List<Song>) songRepository.findAll();
		model.addAttribute("songs",songs);
		return("songlist");
	}
	
	@RequestMapping(value="songs", method = RequestMethod.GET)
	public @ResponseBody List <Song> songListRest() {
		return (List<Song>)songRepository.findAll();
	}
	
	@RequestMapping(value="/newsong", method = RequestMethod.GET)
	public String getNewSong(Model model) {
		model.addAttribute("song", new Song());
		model.addAttribute("genres", genreRepository.findAll());
		return "addsong";
	}
	
	@RequestMapping(value="/savesong", method = RequestMethod.POST)
	public String saveSong(@ModelAttribute Song song) {
		songRepository.save(song);
		return "redirect:/songlist";
	}
	
	@RequestMapping(value="/deletesong/{id}", method = RequestMethod.GET)
	public String deleteSong(@PathVariable("id") Long songId) {
		songRepository.deleteById(songId);
		return "redirect:../songlist";
	}
	
	@RequestMapping(value="/song/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Song> findSongRest(@PathVariable("id") Long songId) {	
    	return songRepository.findById(songId);
    } 

}
