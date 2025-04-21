package com.recordslabel.labelapp.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongDTO {

    private long id;
    @NotNull(message = "title must not be null")
    @NotBlank(message = "title must be a non-empty string")
    private String title;
    private Long albumId;
    private Long artistId;

}
