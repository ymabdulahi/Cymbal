package com.cymbal.artist;

import org.springframework.jdbc.core.RowMapper;

import com.cymbal.album.Album;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDate;

public class ArtistSQL implements RowMapper<Artist> {
    @Override
    public Artist mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Artist(
                resultSet.getInt("id"),
                resultSet.getString("artist_name"),
                resultSet.getString("nationality"),
                resultSet.getString("biggest_hit")
        );
    }
}
