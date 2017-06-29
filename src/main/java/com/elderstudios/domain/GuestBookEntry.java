package com.elderstudios.domain;

import javax.persistence.*;

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

    private String user;
    private String comment;

    public GuestBookEntry() {
    }

    public GuestBookEntry(String user, String comment) {
        this.user = user;
        this.comment = comment;
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

    @Override
    public String toString () {
        return "GuestBookEntry{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
