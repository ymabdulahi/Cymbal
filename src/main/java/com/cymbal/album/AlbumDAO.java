package com.cymbal.album;

import com.cymbal.song.Song;

import java.time.LocalDate;
import java.util.List;

public interface AlbumDAO {
    List<Album> getAlbumById(int id);

    List<Album> getAllAlbums();

    int addAlbum(Album album);

    int updateAlbum(int id, Album album);

    int deleteAlbum(int id);

    List<Album> getAlbumByName(String name);

    List<Album> getAlbumsByArtist(int artist_id);

    List<Album> getAlbumsByGenre(String genre);

    List<Album> getAlbumsByYear(LocalDate start_date, LocalDate end_date);

    List<Album> getAlbumsByArtistName(String artist_name);
}
