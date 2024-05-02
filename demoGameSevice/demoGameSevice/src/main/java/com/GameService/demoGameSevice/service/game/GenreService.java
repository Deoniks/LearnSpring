package com.GameService.demoGameSevice.service.game;

import com.GameService.demoGameSevice.domain.game.Game;
import com.GameService.demoGameSevice.domain.game.Genre;

import java.util.List;

public interface GenreService {
    List<Genre>getAll();
    void save(Genre genre);
    void update(Long id,Genre genre);
    void delete(Genre genre);
    Genre getById(Long id);
}
