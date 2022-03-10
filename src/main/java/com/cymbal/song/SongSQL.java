package com.cymbal.song;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class SongSQL implements RowMapper<Song> {

    @Override
    public Song mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Song(
                resultSet.getInt("id"),
                resultSet.getString("song_name"),
                resultSet.getString("genre"),
                resultSet.getInt("duration"),
                resultSet.getInt("artist_id"),
                resultSet.getInt("album_id"),
                LocalDate.parse(resultSet.getString("release_date")),
                resultSet.getString("languages"),
                resultSet.getString("platform")
        );
    }
}

