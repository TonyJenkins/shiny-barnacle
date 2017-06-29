package com.elderstudios.service;

import com.elderstudios.domain.GuestBookEntry;
import com.elderstudios.domain.GuestBookEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tony on 29/06/17.
 */

@Service
public class GuestBookService {

    @Autowired
    private GuestBookEntryRepository guestBookEntryRepository;

    public List <GuestBookEntry> findAllEntries() {
        return this.guestBookEntryRepository.findAll ();
    }
}
