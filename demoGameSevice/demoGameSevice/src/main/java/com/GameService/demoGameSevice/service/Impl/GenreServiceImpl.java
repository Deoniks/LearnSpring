package com.GameService.demoGameSevice.service.Impl;

import com.GameService.demoGameSevice.domain.game.Genre;
import com.GameService.demoGameSevice.repository.game.GenreRepository;
import com.GameService.demoGameSevice.service.game.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    private Logger log = LoggerFactory.getLogger(GenreServiceImpl.class);
    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<Genre> getAll() {
        log.info("Find all: {}",genreRepository.findAll());
        return genreRepository.findAll();
    }

    @Override
    public void save(Genre genre) {
        genreRepository.save(genre);
        log.info("Save genre: {}", genreRepository.findById(genre.getId()));
    }

    @Override
    public void update(Long id,Genre genre) {
        if(!genreRepository.findById(id).isEmpty()){
            genreRepository.save(genre);
            log.info("Update genre: {}",genreRepository.findById(genre.getId()));
        }else log.info("Not find genre");
    }

    @Override
    public void delete(Genre genre) {
        log.info("Delete genre: {}",genreRepository.findById(genre.getId()));
        genreRepository.delete(genre);
    }

    @Override
    public Genre getById(Long id) {
        log.info("Find genre: {}",genreRepository.findById(id));
        return genreRepository.findById(id).orElse(null);
    }
}
