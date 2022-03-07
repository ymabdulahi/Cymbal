package artist;

import java.util.Objects;

public class Artist {
    private int id;
    private String artist_name;
    private String nationality;
    private String biggest_hit;

    public Artist(int id, String name, String nationality, String biggestHit) {
        this.id = id;
        this.artist_name = name;
        this.nationality = nationality;
        this.biggest_hit = biggestHit;
    }

    public Artist(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBiggest_hit() {
        return biggest_hit;
    }

    public void setBiggest_hit(String biggest_hit) {
        this.biggest_hit = biggest_hit;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + artist_name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", biggestHit='" + biggest_hit + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return Objects.equals(artist_name, artist.artist_name) && Objects.equals(nationality, artist.nationality) && Objects.equals(biggest_hit, artist.biggest_hit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artist_name, nationality, biggest_hit);
    }
}
