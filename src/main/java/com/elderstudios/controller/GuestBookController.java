package com.elderstudios.controller;

import com.elderstudios.domain.GuestBookEntry;
import com.elderstudios.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

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
    public String addComment (Model model,
                              @Valid @ModelAttribute ("newEntry") GuestBookEntry newEntry,
                              BindingResult bindingResult) {

        if (bindingResult.hasErrors ()) {
            model.addAttribute ("entries", this.guestBookService.findAllEntries ());

            return "guestbook_form";
        }
        else {
            this.guestBookService.save(newEntry);

            return "redirect:/";
        }
    }

    @GetMapping (value = "/delete/{id}")
    public String deleteComment (@PathVariable Integer id) {

        this.guestBookService.delete (id);

        return "redirect:/";
    }

    @GetMapping (value = "update/{id}")
    public String editComment (Model model, @PathVariable Integer id) {

        model.addAttribute ("entries", this.guestBookService.findAllEntries ());
        model.addAttribute ("newEntry", this.guestBookService.findOne (id));

        return "edit_guestbook_form";
    }

    @PostMapping (value = "update/{id}")
    public String saveComment (Model model,
                               @Valid @ModelAttribute ("newEntry") GuestBookEntry newEntry,
                               @PathVariable Integer id,
                               BindingResult bindingResult) {

        if (bindingResult.hasErrors ()) {
            model.addAttribute ("entries", this.guestBookService.findAllEntries ());

            return "guestbook_form";
        }
        else {
            GuestBookEntry current = this.guestBookService.findOne (id);

            current.setUser (newEntry.getUser());
            current.setComment (newEntry.getComment());

            this.guestBookService.save(current);

            return "redirect:/";
        }
    }
}
