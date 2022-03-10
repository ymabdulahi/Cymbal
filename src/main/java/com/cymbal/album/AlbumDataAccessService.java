package com.cymbal.album;

import com.cymbal.song.Song;
import com.cymbal.song.SongSQL;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository("cymbalAlbum")
public class AlbumDataAccessService implements AlbumDAO {
    private JdbcTemplate jdbcTemplate;

    public AlbumDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Album> getAlbumById(int id){
        var sql = """
                SELECT * FROM albums
                WHERE id = ?
                 """;
        return jdbcTemplate.query(sql, new AlbumSQL(), id);
    };

    @Override
    public List<Album> getAllAlbums(){
        var sql = """
                SELECT * FROM albums;
                 """;
        return jdbcTemplate.query(sql, new AlbumSQL());
    };

    @Override
    public List<Album> getAlbumByName(String name) {
        var sql = """
                SELECT *
                FROM albums
                WHERE LOWER(album_name) LIKE LOWER(?)
                 """;
        return jdbcTemplate.query(sql, new AlbumSQL(), name+'%');
    }

    @Override
    public List<Album> getAlbumsByArtist(int artist_id){
        var sql = """
                SELECT *
                FROM albums
                WHERE artist_id = ?
                 """;
        return jdbcTemplate.query(sql, new AlbumSQL(), artist_id);
    }

    @Override
    public List<Album> getAlbumsByGenre(String genre){
        var sql = """
                SELECT *
                FROM albums
                WHERE LOWER(genre) = LOWER(?)
                 """;
        return jdbcTemplate.query(sql, new AlbumSQL(), genre);
    }

    @Override
    public List<Album> getAlbumsByYear(LocalDate start_date, LocalDate end_date){
        var sql = """
                SELECT *
                FROM albums
                WHERE release_date >= ? AND release_date <= ?
                 """;
        return jdbcTemplate.query(sql, new AlbumSQL(), start_date, end_date);
    }

    public List<Album> getAlbumsByDecade(LocalDate start_date, LocalDate end_date){
        var sql = """
                SELECT *
                FROM albums
                WHERE release_date >= ? AND release_date <= ?
                 """;
        return jdbcTemplate.query(sql, new AlbumSQL(), start_date, end_date);
    }

    @Override
    public List<Album> getAlbumsByArtistName(String artist_name){
        var sql = """
                SELECT albums.id, album_name, artist_id, genre, release_date, number_of_tracks
                FROM albums
                INNER JOIN artists
                ON artists.id = albums.artist_id
                WHERE LOWER(artists.artist_name) = LOWER(?)
                 """;
        return jdbcTemplate.query(sql, new AlbumSQL(), artist_name);
    }

    @Override
    public int addAlbum(Album album){
        var sql = """
                INSERT INTO albums(album_name, artist_id, genre, release_date, number_of_tracks)
                VALUES (?, ?, ?, ?, ?);
                 """;
        return jdbcTemplate.update(
                sql,
                album.getAlbum_name(), album.getArtist_id(), album.getGenre(), album.getRelease_date(), album.getNumber_of_tracks()
        );
    };

    @Override
    public int updateAlbum(int id, Album album){
        var sql = """
                    UPDATE albums
                    SET album_name=?, artist_id=?, genre=?, release_date=?, number_of_tracks=?
                    WHERE id = ? """;
        return jdbcTemplate.update(sql,album.getAlbum_name(), album.getArtist_id(), album.getGenre(),
                album.getRelease_date(), album.getNumber_of_tracks(), album.getId());

    };

    @Override
    public int deleteAlbum(int id){
        var sql = """
                DELETE FROM albums
                WHERE id = ?
                """;
        return jdbcTemplate.update(sql, id);
    };

}
