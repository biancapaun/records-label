package com.recordslabel.labelapp.controllers;

import com.recordslabel.labelapp.dtos.SongDTO;
import com.recordslabel.labelapp.services.SongService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/song")
public class SongController {

    SongService songService;
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @PostMapping("/create")
    public String createSong(@RequestParam("albumId") Long albumId,
                             @RequestParam("artistId") Long artistId,
                             @Valid @ModelAttribute("newSong") SongDTO songDTO,
                             BindingResult bindingResult) {
        songDTO.setAlbumId(albumId);
        songDTO.setArtistId(artistId);

        if (bindingResult.hasErrors()) {
            return "redirect:/artist/details/" + artistId;
        }

        songService.createSongForAlbum(songDTO);
        return "redirect:/artist/details/" + artistId;
    }

}
