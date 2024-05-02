package com.GameService.demoGameSevice.controller.game;

import com.GameService.demoGameSevice.domain.game.Game;
import com.GameService.demoGameSevice.domain.game.Genre;
import com.GameService.demoGameSevice.repository.game.GameRepository;
import com.GameService.demoGameSevice.repository.game.GenreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    private final GenreRepository genreRepository;

    private Logger log = LoggerFactory.getLogger(GameController.class);

    @Autowired
    public GenreController(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

    @GetMapping("/findAll")
    public List<Genre> getAll(){
        log.info("Find all: {\n}",genreRepository.findAll());
        return genreRepository.findAll();
    }
    @GetMapping("/findBy/{id}")
    public Genre getById(@PathVariable Long id){
        log.info("Find genre: {}",genreRepository.findById(id));
        return genreRepository.findById(id).orElse(null);
    }
    @PostMapping("/save")
    public void save(@RequestBody Genre genre){
        genreRepository.save(genre);
        log.info("Save genre: {}",genreRepository.findById(genre.getId()));
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id,@RequestBody Genre genre){
        if(!genreRepository.findById(id).isEmpty()){
            genreRepository.save(genre);
            log.info("Update genre: {}",genreRepository.findById(genre.getId()));
        }else log.info("Not find id");
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        log.info("Delete genre: {}",genreRepository.findById(id));
        genreRepository.deleteById(id);
    }
}
