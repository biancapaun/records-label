package com.recordslabel.labelapp.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "artist")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Artist {

    @Id
    @Column(name="id_artist")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nume_scena")
    private String sceneName;

    @Column(name="nume_real")
    private String realName;

    @Column(name="data_nasterii")
    private LocalDate dateOfBirth;

    @Column(name="tara_origine")
    private String originCountry;

    @OneToMany(mappedBy = "artist", fetch = FetchType.EAGER)
    private List<Album> albums;

    @OneToMany(mappedBy = "artist")
    private List<Contract> contracts;

    @OneToMany(mappedBy = "artist")
    private List<Prize> prizes;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "colaborare",
            joinColumns = @JoinColumn(name = "id_artist"),
            inverseJoinColumns = @JoinColumn(name = "id_piesa"))
    public List<Song> collaboratedSongs;



}
