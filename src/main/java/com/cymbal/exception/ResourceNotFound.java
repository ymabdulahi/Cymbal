package com.cymbal.exception;

import com.cymbal.song.Song;
import com.cymbal.song.SongDAO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(String message){super(message);}
}