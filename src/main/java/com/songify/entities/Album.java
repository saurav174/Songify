package com.songify.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "album")
public class Album implements Serializable {

    @Id
    @Column(name="albumid",nullable = false)
    String Albumid;

    @Column(name = "album_name",nullable = false)
    String AlbumName;

    @Column(name = "album_song",nullable = false)
    String AlbumSong;
    public String getAlbumid() {
        return Albumid;
    }

    public void setAlbumid(String albumid) {
        Albumid = albumid;
    }

    public String getAlbumName() {
        return AlbumName;
    }

    public void setAlbumName(String albumName) {
        AlbumName = albumName;
    }

    public String getAlbumSong() {
        return AlbumSong;
    }

    public void setAlbumSong(String albumSong) {
        AlbumSong = albumSong;
    }




}
