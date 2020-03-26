package com.songify.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "song")
public class Song implements Serializable {

    @Id
    @Column(name = "songid",nullable = false)
    String SongId;

    @Column(name = "song_name",nullable = false)
    String SongName;

    @Column(name = "song_location",nullable = false)
    String SongLocation;
    public String getSongId() {
        return SongId;
    }

    public void setSongId(String songId) {
        SongId = songId;
    }

    public String getSongName() {
        return SongName;
    }

    public void setSongName(String songName) {
        SongName = songName;
    }

    public String getSongLocation() {
        return SongLocation;
    }

    public void setSongLocation(String songLocation) {
        SongLocation = songLocation;
    }


}
