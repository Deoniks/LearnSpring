package com.GameService.demoGameSevice.service.game;

import com.GameService.demoGameSevice.domain.game.Game;
import com.GameService.demoGameSevice.domain.user.Gamer;

import java.util.List;

public interface GameService {
    List<Game>getAll();
    void save(Game game);
    void update(Long id,Game game);
    void delete(Game game);
    void buyGame(Long id, Gamer gamer);
    Game getById(Long id);
}
