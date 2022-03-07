package artist;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("chickenArtist")
public class ArtistDataAccessService implements ArtistDAO{
    private JdbcTemplate jdbcTemplate;

    public ArtistDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Artist> getArtistById(int id){
        var sql = """
                SELECT * FROM artists
                WHERE id = ?
                 """;
        return jdbcTemplate.query(sql, new ArtistRowMapper(), id);
    };
    @Override
    public List<Artist> getAllArtists(){
        var sql = """
                SELECT * FROM artists;
                 """;
        return jdbcTemplate.query(sql, new ArtistRowMapper());

    };
    @Override
    public List<Artist> getArtistByName(String name){
        var sql = """
                SELECT *
                FROM artists
                WHERE LOWER(artist_name) LIKE LOWER(?)
                 """;
        return jdbcTemplate.query(sql, new ArtistRowMapper(), name+'%');
    }
    @Override
    public List<Artist> getArtistByNationality(String nationality){
        var sql = """
                SELECT *
                FROM artists
                WHERE LOWER(nationality) LIKE LOWER(?)
                 """;
        return jdbcTemplate.query(sql, new ArtistRowMapper(), nationality+'%');
    }
    @Override
    public List<Artist> getArtistByBiggestHit(String biggest_hit){
        var sql = """
                SELECT *
                FROM artists
                WHERE LOWER(biggest_hit) LIKE LOWER(?)
                 """;
        return jdbcTemplate.query(sql, new ArtistRowMapper(), biggest_hit+'%');
    }

    @Override
    public int addArtist(Artist artist){
        var sql = """
                INSERT INTO artists(artist_name, nationality, biggest_hit)
                VALUES (?, ?, ?);
                 """;
        return jdbcTemplate.update(
                sql,
                artist.getArtist_name(), artist.getNationality(), artist.getBiggest_hit()
        );

    };

    @Override
    public int updateArtist(int id, Artist artist){
        var sql = """
                    UPDATE artists
                    SET artist_name=?, nationality=?, biggest_hit=?
                    WHERE id = ? """;
        return jdbcTemplate.update(sql,artist.getArtist_name(), artist.getNationality(), artist.getBiggest_hit(), artist.getId()
        );
    };
    @Override
    public int deleteArtist(int id){
        var sql = """
                DELETE FROM artist
                WHERE id = ?
                """;
        return jdbcTemplate.update(sql, id);
    };
}