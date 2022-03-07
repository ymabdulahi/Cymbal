package album;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class AlbumRowMapper implements RowMapper<Album> {

    @Override
    public Album mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Album(
                resultSet.getInt("id"),
                resultSet.getString("album_name"),
                resultSet.getInt("artist_id"),
                resultSet.getString("genre"),
                LocalDate.parse(resultSet.getString("release_date")),
                resultSet.getInt("number_of_tracks")
        );
    }
}