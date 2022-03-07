package artist;

import java.util.List;

public interface ArtistDAO {
    List<Artist> getArtistById(int id);
    List<Artist> getAllArtists();
    int addArtist(Artist artist);
    int updateArtist(int id, Artist artist);
    int deleteArtist(int id);
    List<Artist> getArtistByName(String name);
    List<Artist> getArtistByNationality(String nationality);
    List<Artist> getArtistByBiggestHit(String biggest_hit);
}
