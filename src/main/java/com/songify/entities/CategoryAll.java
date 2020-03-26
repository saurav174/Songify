package com.songify.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "category_all")
public class CategoryAll implements Serializable {

    @Id
    @Column(name = "categoryid",nullable = false)
    String CategoryId;

    @Column(name = "song_name",nullable = false)
    String Name;

    @Column(name = "type",nullable = false)
    String Type;

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }



}
