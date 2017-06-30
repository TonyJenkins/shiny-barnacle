package com.elderstudios.controller;

import com.elderstudios.domain.GuestBookEntry;
import com.elderstudios.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        model.addAttribute ("newEntry", new GuestBookEntry ());

        return "guestbook_form";
    }

    @PostMapping (value = "/")
    public String addComment (@ModelAttribute ("newEntry") GuestBookEntry newEntry) {

        this.guestBookService.save (newEntry);

        return "redirect:/";
    }

    @GetMapping (value = "/delete/{id}")
    public String deleteComment (@PathVariable Integer id) {

        this.guestBookService.delete (id);

        return "redirect:/";
    }
}
