package com.recordslabel.labelapp.controllers;

import com.recordslabel.labelapp.dtos.*;
import com.recordslabel.labelapp.services.*;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/artist")
public class ArtistController {

    ArtistServiceImpl artistService;
    AlbumServiceImpl albumService;
    SongServiceImpl songService;
    PrizeServiceImpl prizeService;
    ContractServiceImpl contractService;

    public ArtistController(ArtistServiceImpl artistService, AlbumServiceImpl albumService,
                            SongServiceImpl songService, PrizeServiceImpl prizeService,
                            ContractServiceImpl contractService) {
        this.artistService = artistService;
        this.albumService = albumService;
        this.songService = songService;
        this.prizeService = prizeService;
        this.contractService = contractService;
    }

    @GetMapping("")
    public String artistList(@RequestParam(name = "sortDir", required = false, defaultValue = "asc") String sortDir, Model model) {

        List<ArtistDTO> artists = sortDir.equals("desc")
                ? artistService.findAllArtistsSortedDesc()
                : artistService.findAllArtistsSortedAsc();

        model.addAttribute("artists", artists);
        model.addAttribute("sortDir", sortDir);

        return "artist/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        ArtistDTO artist = artistService.findArtistById(id);
        model.addAttribute("artist", artist);
        return "artist/form";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("artist", new ArtistDTO());
        return "artist/form";
    }

    @PostMapping("/create")
    public String createArtist(@Valid @ModelAttribute("artist") ArtistDTO artistDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "artist/form";
        }
        artistService.createArtist(artistDto);
        return "redirect:/artist";
    }

    @PostMapping("/edit/{id}")
    public String updateArtist(@PathVariable Long id, @ModelAttribute("artist") ArtistDTO artistDto) {
        artistService.updateArtist(id, artistDto);
        return "redirect:/artist";
    }

    @GetMapping("/delete/{id}")
    public String deleteArtist(@PathVariable Long id) {
        artistService.deleteArtistById(id);
        return "redirect:/artist";
    }

    @GetMapping("/details/{id}")
    public String showArtistDetails(@PathVariable Long id, Model model) {
        ArtistDTO artist = artistService.findArtistById(id);
        model.addAttribute("artist", artist);

        List<AlbumDTO> albums = albumService.findAlbumsByArtistId(id);
        List<PrizeDTO> prizes = prizeService.findPrizesById(id);
        List<ContractDTO> contracts = contractService.findContractsById(id);

        setSongsListToAlbum(albums);
        model.addAttribute("albums", albums);
        model.addAttribute("prizes", prizes);
        model.addAttribute("contracts", contracts);
        model.addAttribute("newSong", new SongDTO());


        return "artist/details";
    }

    private void setSongsListToAlbum(List<AlbumDTO> albums) {
        albums.stream().forEach(album -> album.setSongs(songService.findSongByAlbumId(album.getId())));
    }


}
