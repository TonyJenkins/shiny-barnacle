package com.elderstudios.controller;

import com.elderstudios.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by tony on 29/06/17.
 */

@Controller
public class GuestBookController {

    @Autowired
    private GuestBookService guestBookService;

    @GetMapping (value = "/")
    public String displayGuestBook (Model model) {

        model.addAttribute ("entries", this.guestBookService.findAllEntries ());

        return "guestbook_form";
    }
}
