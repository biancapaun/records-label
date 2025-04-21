package com.recordslabel.labelapp.repositories;

import com.recordslabel.labelapp.entities.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {
}
