package song;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/songs")
public class SongController {
    private SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public @ResponseBody
    List<Song> getAllSongs(){
        return songService.getAllSongs();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Optional<Song> getSongById(@PathVariable int id){
        return (songService.getSongById(id));
    }

    @GetMapping("/name/{name}")
    public @ResponseBody List<Song> getSongByName(@PathVariable String name){
        return songService.getSongByName(name);
    }

    @GetMapping("/artist/{artist_id}")
    public @ResponseBody List<Song> getSongsByArtist(@PathVariable int artist_id){
        return songService.getSongsByArtist(artist_id);
    }

    @GetMapping("/artist_name/{artist_name}")
    public @ResponseBody List<Song> getSongsByArtistName(@PathVariable String artist_name){
        return songService.getSongsByArtistName(artist_name);
    }

    @GetMapping("/album/{album_id}")
    public @ResponseBody List<Song> getSongsByAlbum(@PathVariable int album_id){
        return songService.getSongsByAlbum(album_id);
    }

    @GetMapping("/album_name/{album_name}")
    public @ResponseBody List<Song> getSongsByAlbumName(@PathVariable String album_name){
        return songService.getSongsByAlbumName(album_name);
    }

    @GetMapping("/genre/{genre}")
    public @ResponseBody List<Song> getSongsByGenre(@PathVariable String genre){
        return songService.getSongsByGenre(genre);
    }

    @GetMapping("/year/{release_year}")
    public @ResponseBody List<Song> getSongsByYear(@PathVariable int release_year){
        return songService.getSongsByYear(release_year);
    }

    @PostMapping("/add")
    public String addSong(@RequestBody Song song) {
        return songService.addSong(song);
    }

    @PutMapping("/{id}")
    public String updateSong(@PathVariable int id,
                             @RequestBody Song song) {
        return songService.updateSong(id, song);
    }

    @DeleteMapping("/{id}")
    public String deleteSong(@PathVariable int id) {
        return songService.deleteSong(id);
    }
}
