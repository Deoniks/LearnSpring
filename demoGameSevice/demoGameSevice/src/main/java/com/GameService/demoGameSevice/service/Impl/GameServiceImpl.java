package com.GameService.demoGameSevice.service.Impl;

import com.GameService.demoGameSevice.domain.game.Game;
import com.GameService.demoGameSevice.repository.game.GameRepository;
import com.GameService.demoGameSevice.service.game.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private Logger log = LoggerFactory.getLogger(GameServiceImpl.class);

    @Autowired
    private GameRepository gameRepository;

    @Override
    public List<Game> getAll() {
        log.info("Find all: {}",gameRepository.findAll());
        return gameRepository.findAll();
    }

    @Override
    public void save(Game game) {
        gameRepository.save(game);
        log.info("Save game: {}",gameRepository.findById(game.getId()));
    }

    @Override
    public void update(Long id,Game game) {
        if(!gameRepository.findById(id).isEmpty()){
            gameRepository.save(game);
            log.info("Update game: {}",gameRepository.findById(game.getId()));
        }else log.info("Not find game");
    }

    @Override
    public void delete(Game game) {
        log.info("Delete game: {}",gameRepository.findById(game.getId()));
        gameRepository.delete(game);
    }

    @Override
    public Game getById(Long id) {
        log.info("Find game: {}", gameRepository.findById(id));
        return gameRepository.findById(id).orElse(null);
    }
}
