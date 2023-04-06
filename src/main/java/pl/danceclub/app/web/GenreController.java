package pl.danceclub.app.web;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import pl.danceclub.app.domain.genre.GenreService;
import pl.danceclub.app.domain.genre.dto.GenreDto;
import pl.danceclub.app.domain.unit.UnitService;
import pl.danceclub.app.domain.unit.dto.UnitDto;

import java.util.List;

@Controller
public class GenreController {

    private final GenreService genreService;
    private final UnitService unitService;

    public GenreController(GenreService genreService, UnitService unitService) {
        this.genreService = genreService;
        this.unitService = unitService;
    }

    @GetMapping("genre/{name}")
    public String getGenreList(@PathVariable String name, Model model){
        GenreDto genreDto = genreService.findGenreByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<UnitDto> unitDto = unitService.findAllByGenre(name);
        model.addAttribute("heading", genreDto.getName());
        model.addAttribute("description", genreDto.getDescription());
        model.addAttribute("units", unitDto);
        return "unit-listing";
    }

    @GetMapping("genres")
    public String getGenres(Model model){
        List<GenreDto> allGenres = genreService.findAllGenres();
        model.addAttribute("genres", allGenres);
        return "genre-listing";
    }
}
