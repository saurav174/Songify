package com.songify.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "singer")
public class Singer implements Serializable {


    @Id
    @Column(name = "singerid",nullable = false)
    String SIngerId;

    @Column(name = "singer_name",nullable = false)
    String SingerName;

    @Column(name = "singer_song",nullable = false)
    String SingerSong;


    public String getSIngerId() {
        return SIngerId;
    }

    public void setSIngerId(String SIngerId) {
        this.SIngerId = SIngerId;
    }

    public String getSingerName() {
        return SingerName;
    }

    public void setSingerName(String singerName) {
        SingerName = singerName;
    }

    public String getSingerSong() {
        return SingerSong;
    }

    public void setSingerSong(String singerSong) {
        SingerSong = singerSong;
    }


}
