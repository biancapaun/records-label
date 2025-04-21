package com.recordslabel.labelapp.repositories;

import com.recordslabel.labelapp.entities.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album, Long> {
}
