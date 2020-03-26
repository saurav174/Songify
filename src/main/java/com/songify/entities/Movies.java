package com.songify.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "movies")
public class Movies implements Serializable {

    @Id
    @Column(name = "movieid",nullable = false)
    String MovieId;

    @Column(name = "movie_name",nullable = false)
    String MovieName;

    @Column(name = "song_name",nullable = false)
    String SongName;
    public String getMovieId() {
        return MovieId;
    }

    public void setMovieId(String movieId) {
        MovieId = movieId;
    }

    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String movieName) {
        MovieName = movieName;
    }

    public String getSongName() {
        return SongName;
    }

    public void setSongName(String songName) {
        SongName = songName;
    }

}
