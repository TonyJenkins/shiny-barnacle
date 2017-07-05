package com.elderstudios.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by tony on 29/06/17.
 */
public interface GuestBookEntryRepository extends CrudRepository <GuestBookEntry, Integer> {

    @Override
    List <GuestBookEntry> findAll ();

    List <GuestBookEntry> getGuestBookEntryById (Integer id);

    @Query (value = "select distinct user from entries order by user", nativeQuery = true)
    List <String> findDistinctUsers ();

    @Query (value = "select avg (length (comment)) from entries", nativeQuery = true)
    Double getAverageCommentLength ();

}
