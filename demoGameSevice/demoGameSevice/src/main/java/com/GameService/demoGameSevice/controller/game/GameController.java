package com.GameService.demoGameSevice.controller.game;

import com.GameService.demoGameSevice.domain.game.Game;
import com.GameService.demoGameSevice.repository.game.GameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    private final GameRepository gameRepository;

    private Logger log = LoggerFactory.getLogger(GameController.class);

    @Autowired
    public GameController(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    @GetMapping("/findAll")
    public List<Game>getAll(){
        log.info("Find all: {\n}",gameRepository.findAll());
        return gameRepository.findAll();
    }
    @GetMapping("/findBy/{id}")
    public Game getById(@PathVariable Long id){
        log.info("Find game: {}",gameRepository.findById(id));
        return gameRepository.findById(id).orElse(null);
    }
    @PostMapping("/save")
    public void save(@RequestBody Game game){
        gameRepository.save(game);
        log.info("Save game: {}",gameRepository.findById(game.getId()));
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id,@RequestBody Game game){
        if(!gameRepository.findById(id).isEmpty()){
            gameRepository.save(game);
            log.info("Update game: {}",gameRepository.findById(game.getId()));
        }else log.info("Not find id");
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        log.info("Delete game: {}",gameRepository.findById(id));
        gameRepository.deleteById(id);
    }
}
