package com.elderstudios.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by tony on 29/06/17.
 */

@Entity
@Table (name = "entries")
public class GuestBookEntry {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "entry_id")
    private Integer id;

    @NotEmpty
    private String user;

    @NotEmpty
    private String comment;

    @CreatedDate
    @Column (name = "created_date")
    private Date created;

    @LastModifiedDate
    @Column (name = "modified_date")
    private Date lastUpdated;

    public GuestBookEntry () {
    }

    public GuestBookEntry (String user, String comment) {
        this.user = user;
        this.comment = comment;
    }

    public GuestBookEntry (String user, String comment, Date created, Date lastUpdated) {
        this.user = user;
        this.comment = comment;
        this.created = created;
        this.lastUpdated = lastUpdated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreated () {
        return created;
    }

    public void setCreated (Date created) {
        this.created = created;
    }

    public Date getLastUpdated () {
        return lastUpdated;
    }

    public void setLastUpdated (Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString () {
        return "GuestBookEntry{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", comment='" + comment + '\'' +
                ", created=" + created +
                ", lastUpdated=" + lastUpdated +
                '}';
    }

}
