package com.cymbal.album;
import java.time.LocalDate;
import java.util.Objects;

public class Album {
    private int id;
    private String album_name;
    private int artist_id;
    private String genre;
    private LocalDate release_date;
    private int number_of_tracks;

    public Album( int id, String album_name, int artist_id, String genre, LocalDate release_date, int number_of_tracks) {
        this.id = id;
        this.album_name = album_name;
        this.artist_id = artist_id;
        this.genre = genre;
        this.release_date = release_date;
        this.number_of_tracks = number_of_tracks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public int getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(int artist_id) {
        this.artist_id = artist_id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getRelease_date() {
        return release_date;
    }

    public void setRelease_date(LocalDate release_date) {
        this.release_date = release_date;
    }

    public int getNumber_of_tracks() {
        return number_of_tracks;
    }

    public void setNumber_of_tracks(int number_of_tracks) {
        this.number_of_tracks = number_of_tracks;
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + album_name + '\'' +
                ", artistId='" + artist_id + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseDate=" + release_date +
                ", numberOfTracks=" + number_of_tracks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return number_of_tracks == album.number_of_tracks && Objects.equals(album_name, album.album_name) && Objects.equals(artist_id, album.artist_id) && Objects.equals(genre, album.genre) && Objects.equals(release_date, album.release_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(album_name, artist_id, genre, release_date, number_of_tracks);
    }
}