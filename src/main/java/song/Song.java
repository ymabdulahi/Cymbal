package song;

import java.time.LocalDate;

public class Song {
    private int id;
    private String song_name;
    private String genre;
    private int duration;
    private int artist_id;
    private int album_id;
    private LocalDate release_date;
    private String languages;
    private String platform;

    public Song(int id, String song_name, String genre, int duration, int artist_id, int album_id, LocalDate release_date, String language, String platform) {
        this.id = id;
        this.song_name = song_name;
        this.genre = genre;
        this.duration = duration;
        this.artist_id = artist_id;
        this.album_id = album_id;
        this.release_date = release_date;
        this.languages = language;
        this.platform = platform;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(int artist_id) {
        this.artist_id = artist_id;
    }

    public int getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

    public LocalDate getRelease_date() {
        return release_date;
    }

    public void setRelease_date(LocalDate release_date) {
        this.release_date = release_date;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + song_name + '\'' +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                ", artist_id=" + artist_id +
                ", album_id=" + album_id +
                ", release_date=" + release_date +
                ", language='" + languages + '\'' +
                '}';
    }

}