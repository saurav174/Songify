package com.songify.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "genere")
public class Genere implements Serializable {

    @Id
    @Column(name="genereid",nullable = false)
    String Genereid;

    @Column(name = "genere_name",nullable = false)
    String GenereName;

    @Column(name = "genere_song",nullable = false)
    String GenereSong;
    public String getGenereid() {
        return Genereid;
    }

    public void setGenereid(String genereid) {
        Genereid = genereid;
    }

    public String getGenereName() {
        return GenereName;
    }

    public void setGenereName(String genereName) {
        GenereName = genereName;
    }

    public String getGenereSong() {
        return GenereSong;
    }

    public void setGenereSong(String genereSong) {
        GenereSong = genereSong;
    }



}
