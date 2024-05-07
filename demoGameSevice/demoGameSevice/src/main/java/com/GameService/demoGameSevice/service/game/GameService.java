package com.GameService.demoGameSevice.service.game;

import com.GameService.demoGameSevice.domain.game.Game;

import java.util.List;

public interface GameService {
    List<Game>getAll();
    void save(Game game);
    void update(Long id,Game game);
    void delete(Game game);

    Game getById(Long id);
}
