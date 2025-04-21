package com.recordslabel.labelapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "piesa")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Song {

    @Id
    @Column(name="id_piesa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="titlu")
    private String title;

    @ManyToOne
    @JoinColumn(name="id_album")
    private Album album;

    @ManyToOne
    @JoinColumn(name="id_gen")
    private Genre genre;

    @ManyToMany(mappedBy = "collaboratedSongs", fetch = FetchType.LAZY)
    @JsonIgnore
    public List<Artist> collaboratedArtists;


}
