package com.elderstudios.controller;

import com.elderstudios.domain.GuestBookEntry;
import com.elderstudios.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tony on 04/07/17.
 */

@RestController
public class GuestBookRestController {

    @Autowired
    private GuestBookService guestBookService;

    @GetMapping ("/comments")
    public List <GuestBookEntry> helloWorld () {
        return this.guestBookService.findAllEntries ();
    }
}
