package com.recordslabel.labelapp.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDTO {

    private Long id;

    @NotNull(message = "Album title must not be null")
    @NotBlank(message = "Album title must be a non-empty string")
    private String title;

    private LocalDate releaseDate;

    private GenreDTO genre;

    private List<SongDTO> songs;

    private Long artistId;

}
