package com.cymbal.song;

import org.apache.tomcat.jni.Local;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository("cymbalSong")
public class SongDataAccessService implements SongDAO{

    private JdbcTemplate jdbcTemplate;
    //        private final JdbcTemplate jdbcTemplate;

    public SongDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Song> getAllSongs() {
        var sql = """
                SELECT id, song_name, genre, duration, artist_id, album_id, release_date, languages, platform
                FROM songs
                LIMIT 100;
                 """;
        return jdbcTemplate.query(sql, new SongSQL());
    }

    @Override
    public Optional<Song> getSongById(int id) {
        var sql = """
                SELECT id, song_name, genre, duration, artist_id, album_id, release_date, languages, platform
                FROM songs
                WHERE id = ?
                 """;
        return jdbcTemplate.query(sql, new SongSQL(), id)
                .stream()
                .findFirst();
    }

    @Override
    public List<Song> getSongByName(String name) {
        var sql = """
                SELECT id, song_name, genre, duration, artist_id, album_id, release_date, languages, platform
                FROM songs
                WHERE LOWER(song_name) LIKE LOWER(?)
                 """;
        return jdbcTemplate.query(sql, new SongSQL(), name+'%');
    }

    @Override
    public List<Song> getSongsByArtist(int artist_id) {
        var sql = """
                SELECT id, song_name, genre, duration, artist_id, album_id, release_date, languages, platform
                FROM songs
                WHERE artist_id = ?
                 """;
        return jdbcTemplate.query(sql, new SongSQL(), artist_id);
    }

    @Override
    public List<Song> getSongsByArtistName(String artist_name){
        var sql = """
                SELECT songs.id, song_name, genre, duration, artist_id, album_id, release_date, languages, platform
                FROM artists
                JOIN songs
                ON artists.id = songs.artist_id
                WHERE LOWER(artists.artist_name) = LOWER(?)
                 """;
        return jdbcTemplate.query(sql, new SongSQL(), artist_name);
    }

    @Override
    public List<Song> getSongsByAlbum(int album_id) {
        var sql = """
                SELECT id, song_name, genre, duration, artist_id, album_id, release_date, languages, platform
                FROM songs
                WHERE album_id = ?
                 """;
        return jdbcTemplate.query(sql, new SongSQL(), album_id);
    }

    @Override
    public List<Song> getSongsByAlbumName(String album_name){
        var sql = """
                SELECT songs.id, song_name, songs.genre, duration, songs.artist_id, album_id, songs.release_date, languages, platform
                FROM albums
                JOIN songs
                ON albums.id = songs.album_id
                WHERE LOWER(albums.album_name) = LOWER(?)
                 """;
        return jdbcTemplate.query(sql, new SongSQL(), album_name);
    }

    @Override
    public List<Song> getSongsByGenre(String genre) {
        var sql = """
                SELECT id, song_name, genre, duration, artist_id, album_id, release_date, languages, platform
                FROM songs
                WHERE LOWER(genre) = LOWER(?)
                 """;
        return jdbcTemplate.query(sql, new SongSQL(), genre);
    }

    @Override
    public List<Song> getSongsByYear(LocalDate start_date, LocalDate end_date) {
        var sql = """
                SELECT id, song_name, genre, duration, artist_id, album_id, release_date, languages, platform
                FROM songs
                WHERE release_date >= ? AND release_date <= ?
                 """;
        return jdbcTemplate.query(sql, new SongSQL(), start_date, end_date);
    }

    @Override
    public int addSong(Song song) {
        var sql = """
                INSERT INTO songs(song_name, genre, duration, artist_id, album_id, release_date, languages, platform)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?);
                 """;
        return jdbcTemplate.update(
                sql,
                song.getSong_name(),
                song.getGenre(),
                song.getDuration(),
                song.getArtist_id(),
                song.getAlbum_id(),
                song.getRelease_date(),
                song.getLanguages(),
                song.getPlatform()
        );
    }

    @Override
    public int updateSong(int id, Song song){
        var sql = """
                UPDATE songs
                SET song_name=?, genre=?, duration=?, artist_id=?, album_id=?, release_date=?, languages=?, platform=?
                WHERE id = ?
                """;
        return jdbcTemplate.update(sql, song.getSong_name(), song.getGenre(), song.getDuration(),
                song.getArtist_id(), song.getAlbum_id(), song.getRelease_date(), song.getLanguages(), song.getPlatform(),
                song.getId()
        );
    }

    @Override
    public int deleteSong(int id) {
        var sql = """
            DELETE FROM songs
            WHERE id = ?
            """;
        return jdbcTemplate.update(sql, id);
    }
}
