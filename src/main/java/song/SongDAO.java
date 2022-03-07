package song;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SongDAO {

    List<Song> getAllSongs();
    Optional<Song> getSongById(int id);
    List<Song> getSongByName(String name);
    List<Song> getSongsByArtist(int artist_id);
    List<Song> getSongsByAlbum(int album_id);
    List<Song> getSongsByGenre(String genre);
    List<Song> getSongsByYear(LocalDate start_date, LocalDate end_date);
    List<Song> getSongsByDecade(LocalDate start_date, LocalDate end_date);
    int addSong(Song song);
    int updateSong(int id, Song song);
    int deleteSong(int id);
    List<Song> getSongsByArtistName(String artist_name);
    List<Song> getSongsByAlbumName(String album_name);
}
