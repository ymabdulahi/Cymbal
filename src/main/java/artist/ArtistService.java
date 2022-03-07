package artist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    private ArtistDAO artistDAO;
    @Autowired
    public ArtistService(@Qualifier("chickenArtist") ArtistDAO artistDAO) {
        this.artistDAO = artistDAO;
    }

    public List<Artist> getArtistById(int id) {
        return this.artistDAO.getArtistById(id);
    }

    public List<Artist> getAllArtists() {
        return this.artistDAO.getAllArtists();
    }

    public String addArtist(Artist artist) {
        this.artistDAO.addArtist(artist);
        return "Artist added";
    }

    public String updateArtist(int id, Artist artist) {
        this.artistDAO.updateArtist(id, artist);
        return "Artist updated";
    }

    public String deleteArtist(int id) {
        this.artistDAO.deleteArtist(id);
        return "Artist deleted";
    }

    public List<Artist> getArtistByName(String name) {
        Optional<List<Artist>> artistByNameOptional = Optional.ofNullable(artistDAO.getArtistByName(name));
        if(artistByNameOptional.get().isEmpty()) {
            throw new ResourceNotFound("Sorry! The artist " + name + " has not been found :( Please try again.");
        }
        return artistDAO.getArtistByName(name);
    }

    public List<Artist> getArtistsByNationality(String nationality) {
        return artistDAO.getArtistByNationality(nationality);
    }

    public List<Artist> getArtistByBiggestHit(String biggest_hit) {
        return artistDAO.getArtistByBiggestHit(biggest_hit);
    }
}
