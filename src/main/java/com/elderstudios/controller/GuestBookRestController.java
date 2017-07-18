package com.elderstudios.controller;

import com.elderstudios.domain.GuestBookEntry;
import com.elderstudios.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tony on 04/07/17.
 */

@RestController
@RequestMapping ("/api")
public class GuestBookRestController {

    @Autowired
    private GuestBookService guestBookService;

    @GetMapping ("/comments")
    public List <GuestBookEntry> apiAllComments () {
        return this.guestBookService.findAllEntries ();
    }

    @GetMapping ("/find/{id}")
    public List <GuestBookEntry> apiCommentById (@PathVariable ("id") Integer id) {
        return this.guestBookService.getGuestBookEntryById (id);
    }

    @GetMapping ("/users")
    public List <String> apiGetDistinctUsers () {
        return this.guestBookService.findDistinctUsers ();
    }

    @GetMapping ("/comment_count")
    public Integer getNumberOfComments () {
        return this.guestBookService.getNumberOfComments ();
    }

    @GetMapping ("/average_length")
    public Double getAverageCommentLength () {
        return this.guestBookService.getAverageCommentLength ();
    }

    @GetMapping ("/longest_comment")
    public List <String> getLongestComment () {
        return this.guestBookService.getLongestComment ();
    }

    @DeleteMapping ("/delete/{id}")
    public void deleteCommentById (@PathVariable ("id") Integer id) {
        this.guestBookService.delete (id);
    }

    @PostMapping ("/add")
    public void addComment (@RequestBody GuestBookEntry guestBookEntry) {
        guestBookService.save (guestBookEntry);
    }

    @PutMapping ("/update")
    public void updateComment (@RequestBody GuestBookEntry guestBookEntry) {
        guestBookService.save (guestBookEntry);
    }
}
