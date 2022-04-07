CREATE TABLE artists(
  id BIGSERIAL PRIMARY KEY,
  artist_name TEXT NOT NULL,
  nationality TEXT NOT NULL,
  biggest_hit TEXT NOT NULL
);

CREATE TABLE albums(
    id BIGSERIAL PRIMARY KEY,
    album_name TEXT NOT NULL,
    artist_id INT REFERENCES artists(id),
    genre TEXT NOT NULL,
    release_date DATE NOT NULL,
    number_of_tracks INT NOT NULL
);

CREATE TABLE songs (
    id SERIAL PRIMARY KEY,
    song_name TEXT NOT NULL,
    genre TEXT NOT NULL,
    duration INT NOT NULL,
    artist_id INT REFERENCES artists(id),
    album_id INT REFERENCES albums(id),
    release_date DATE NOT NULL,
    languages TEXT NOT NULL,
    platform TEXT NOT NULL
);