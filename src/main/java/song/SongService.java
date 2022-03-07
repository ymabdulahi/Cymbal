package song;

import album.Album;
import album.AlbumDAO;
import artist.Artist;
import artist.ArtistDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    private SongDAO songDAO;
    private ArtistDAO artistDAO;
    private AlbumDAO albumDAO;

    @Autowired
    public SongService(@Qualifier("chickenSong") SongDAO songDAO, ArtistDAO artistDAO, AlbumDAO albumDAO) {
        this.songDAO = songDAO;
        this.artistDAO = artistDAO;
        this.albumDAO = albumDAO;
    }

    //GET
    public List<Song> getAllSongs() {
        Optional<List<Song>> songOptional = Optional.ofNullable(songDAO.getAllSongs());
        if(songOptional.isEmpty()) {
            throw new ResourceNotFound("Sorry! No songs available right now :(");
        }
        return songDAO.getAllSongs();
    }

    public Optional<Song> getSongById(int id) {
        return Optional.ofNullable(songDAO.getSongById(id)
                .orElseThrow(() -> new ResourceNotFound("Song with id " + id + " not found")));
    }

    public List<Song> getSongByName(String name) {
        Optional<List<Song>> songByNameOptional = Optional.ofNullable(songDAO.getSongByName(name));
        if(songByNameOptional.get().isEmpty()) {
            throw new ResourceNotFound("Sorry! The song " + name + " has not been found :( Please try again.");
        }
        return songDAO.getSongByName(name);
    }


    //TODO return partial matches as well
    public List<Song> getSongsByArtist(int artist_id) {
        Optional<List<Song>> songByArtistOptional = Optional.ofNullable(songDAO.getSongsByArtist(artist_id));
        if(songByArtistOptional.get().isEmpty()) {
            //TODO: return name of artist instead of id
            throw new ResourceNotFound("Sorry! The artist " + artist_id + " has not been found :( Please try again.");
        }
        return songDAO.getSongsByArtist(artist_id);
    }
    //
    public List<Song> getSongsByAlbum(int album_id) {
        Optional<List<Song>> songByAlbumOptional = Optional.ofNullable(songDAO.getSongsByAlbum(album_id));
        if(songByAlbumOptional.get().isEmpty()) {
            //TODO: return name of album instead of id
            throw new ResourceNotFound("Sorry! Album with id " + album_id + " has not been found :( Please try again.");
        }
        return songDAO.getSongsByAlbum(album_id);
    }
    //
    public List<Song> getSongsByGenre(String genre) {
        Optional<List<Song>> songByGenreOptional = Optional.ofNullable(songDAO.getSongsByGenre(genre));
        if(songByGenreOptional.isEmpty()) {
            throw new ResourceNotFound("Sorry, your music taste is too unique. " + genre + " has not been found :(");
        }
        return songDAO.getSongsByGenre(genre);
    }

    public List<Song> getSongsByYear(int release_year) {
        LocalDate start_date = LocalDate.parse(release_year + "-01-01");
        LocalDate end_date = LocalDate.parse(release_year + "-12-31");

        Optional<List<Song>> songByYearOptional = Optional.ofNullable(songDAO.getSongsByYear(start_date, end_date));
        if(songByYearOptional.isEmpty()) {
            throw new ResourceNotFound("Sorry! No songs found for " + release_year + " :( Please try again.");
        }

        return songDAO.getSongsByYear(start_date, end_date);
    }

    //POST
    public String addSong(Song song) {
        //TODO: check artist and album ids exist

        Optional<List<Song>> songOptional = Optional.ofNullable(songDAO.getSongByName(song.getSong_name()));
        if (songOptional.isPresent() && (songOptional.get().contains(song.getArtist_id()))) {
            throw new Conflict("Unable to add song - it already exists!");
        }
        songDAO.addSong(song);
        return "Song added";
    }

    //    //PUT
    public String updateSong(int id, Song song) {
        //check song id exists
        Optional<Song> songOptional = songDAO.getSongById(id);
        if(songOptional.isEmpty()) {
            throw new ResourceNotFound("Sorry! Song with id " + id + " has not been found :(");
        }
        //check update details does not clash with existing song details
        Optional<List<Song>> songOptionalName = Optional.ofNullable(songDAO.getSongByName(song.getSong_name()));
        if (songOptionalName.isPresent() && (songOptionalName.get().contains(song.getArtist_id()))) {
            throw new Conflict("Unable to update song details - song already exists!");
        }
        //check if song is updated in the database
        if(songDAO.updateSong(id, song) == 1) {
            return "Song updated!";
        }
        return "Song not updated...";
        //TODO: make sure updated song is not the same as any other song
    }
    //DELETE
    public String deleteSong(int id) {
        //returning null
//        if(DoesSongExist.check(id)) {
//            songDAO.deleteSong(id);
//        }
        songDAO.deleteSong(id);
        return "Song deleted.";
    }

    public List<Song> getSongsByArtistName(String artist_name) {
        Optional<List<Artist>> artistOptional = Optional.ofNullable(artistDAO.getArtistByName(artist_name));
        if(artistOptional.isEmpty()){
            throw new ResourceNotFound("Sorry! The artist " + artist_name + " has not been found :(");
        }
        return songDAO.getSongsByArtistName(artist_name);
    }

    public List<Song> getSongsByAlbumName(String album_name) {
        Optional<List<Album>> albumOptional = Optional.ofNullable(albumDAO.getAlbumByName(album_name));
        if(albumOptional.isEmpty()){
            throw new ResourceNotFound("Sorry! The album " + album_name + " has not been found :(");
        }
        return songDAO.getSongsByAlbumName(album_name);
    }

}