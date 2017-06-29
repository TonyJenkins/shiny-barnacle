package com.elderstudios.domain;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by tony on 29/06/17.
 */
public interface GuestBookEntryRepository extends CrudRepository <GuestBookEntry, Integer> {

}
