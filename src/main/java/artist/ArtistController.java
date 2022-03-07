package artist;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/artists")
public class ArtistController {
    private ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    //GET
    //Method to get all artists
    @GetMapping
    public @ResponseBody
    List<Artist> getAllArtists(){
        return this.artistService.getAllArtists();
    }

    //Method to get a single artist by its id (primary key)
    @GetMapping("/{id}")
    public @ResponseBody
    List<Artist> getArtistById(@PathVariable int id){
        return this.artistService.getArtistById(id);
    }

    //Method to get artist by name
    @GetMapping("/name/{name}")
    public @ResponseBody List<Artist> getArtistByName(@PathVariable String name){
        return artistService.getArtistByName(name);
    }

    //Method to get artists by nationality
    @GetMapping("/nationality/{nationality}")
    public @ResponseBody List<Artist> getArtistsByNationality(@PathVariable String nationality){
        return artistService.getArtistsByNationality(nationality);
    }

    //Method to get artist by biggest hit
    @GetMapping("/biggest_hit/{biggest_hit}")
    public @ResponseBody List<Artist> getArtistByBiggestHit(@PathVariable String biggest_hit){
        return artistService.getArtistByBiggestHit(biggest_hit);
    }

    //TODO Create a get album by decade function

    //POST
    //Add song
    @PostMapping("/add")
    public void addArtist(@RequestBody Artist artist) {
        artistService.addArtist(artist);
    }

    //PUT
    //Method to update a whole album
    @PutMapping("/{id}")
    public void updateArtist(@PathVariable int id,
                             @RequestBody Artist artist) {
        artistService.updateArtist(id, artist);
    }

    //DELETE
    //Method to delete an album
    @DeleteMapping("/{id}")
    public void deleteArtist(@PathVariable int id) {
        artistService.deleteArtist(id);
    }

}
