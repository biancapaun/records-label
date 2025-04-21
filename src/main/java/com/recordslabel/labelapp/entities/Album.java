package com.recordslabel.labelapp.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "album")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Album {

    @Id
    @Column(name="id_album")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="titlu")
    private String title;

    @Column(name="data_lansare")
    private LocalDate releaseDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="id_gen")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name="id_artist")
    private Artist artist;

    @OneToMany(mappedBy = "album")
    private List<Song> songs;

    @OneToMany(mappedBy = "album")
    private List<Production> productions;

}
