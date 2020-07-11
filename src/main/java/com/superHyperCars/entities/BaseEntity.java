package com.songify.entities;


import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public class BaseEntity {
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id"
    )
    @Id
    private BigInteger id;
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

    public BigInteger getId() {
        return this.id;
    }

    public void setId(BigInteger id) {
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

    public String toString() {
        return "BaseEntity [id=" + this.id + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + "]";
    }
}
