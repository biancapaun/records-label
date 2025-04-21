package com.recordslabel.labelapp.repositories;

import com.recordslabel.labelapp.entities.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    List<Artist> findAllByOrderByIdAsc();

    @Query("SELECT a FROM Artist a LEFT JOIN FETCH a.albums WHERE a.id = :id")
    Optional<Artist> findByIdWithAlbums(@Param("id") Long id);

    Page<Artist> findAll(Pageable pageable);
    List<Artist> findAllByOrderBySceneNameAsc();
    List<Artist> findAllByOrderBySceneNameDesc();

}
