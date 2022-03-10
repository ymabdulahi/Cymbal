package com.cymbal.album;

import com.cymbal.song.Song;
import com.cymbal.song.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.ToDoubleBiFunction;

@RestController
@RequestMapping("/api/v1/albums")
public class AlbumController {
    private AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public @ResponseBody
    List<Album> getAllAlbums(){
        return albumService.getAllAlbums();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    List<Album> getAlbumById(@PathVariable int id){
        return albumService.getAlbumById(id);
    }

    @GetMapping("/name/{name}")
    public @ResponseBody List<Album> getAlbumByName(@PathVariable String name){
        return albumService.getAlbumByName(name);
    }

    @GetMapping("/com/cymbal/artist/{artist_id}")
    public @ResponseBody List<Album> getAlbumsByArtist(@PathVariable int artist_id){
        return albumService.getAlbumsByArtist(artist_id);
    }

    @GetMapping("/artist_name/{artist_name}")
    public @ResponseBody List<Album> getAlbumsByArtistName(@PathVariable String artist_name){
        return albumService.getAlbumsByArtistName(artist_name);
    }

    @GetMapping("/genre/{genre}")
    public @ResponseBody List<Album> getAlbumsByGenre(@PathVariable String genre){
        return albumService.getAlbumsByGenre(genre);
    }

    @GetMapping("/year/{release_year}")
    public @ResponseBody List<Album> getAlbumsByYear(@PathVariable int release_year){
        return albumService.getAlbumsByYear(release_year);
    }

    @PostMapping("/add")
    public void addAlbum(@RequestBody Album album) {
        albumService.addAlbum(album);
    }

    @PutMapping("/{id}")
    public void updateAlbum(@PathVariable int id,
                            @RequestBody Album album) {
        albumService.updateAlbum(id, album);
    }

    @DeleteMapping("/{id}")
    public void deleteAlbum(@PathVariable int id) {
        albumService.deleteAlbum(id);
    }

}
