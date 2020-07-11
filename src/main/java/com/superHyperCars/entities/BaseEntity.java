package com.superHyperCars.entities;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id"
    )
    @Id
    private Long id;
    @Column(
            name = "created_at"
    )
    private Date createdAt;
    @Column(
            name = "updated_at"
    )
    private Date updatedAt;

    public BaseEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PrePersist
    void createDate() {
        if (this.createdAt == null) {
            this.setCreatedAt(new Date());
        }

        this.setUpdatedAt(new Date());
    }

    @PreUpdate
    void updatedAt() {
        this.setUpdatedAt(new Date());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

