package com.GameService.demoGameSevice.controller.gamer;


import com.GameService.demoGameSevice.controller.game.GameController;
import com.GameService.demoGameSevice.domain.game.Game;
import com.GameService.demoGameSevice.domain.user.Gamer;
import com.GameService.demoGameSevice.repository.user.GamerRepository;
import com.GameService.demoGameSevice.service.user.GamerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gamer")
public class GamerController {
    @Autowired
    private GamerRepository gamerRepository;

    private Logger log = LoggerFactory.getLogger(GameController.class);
    @Autowired
    public GamerController(GamerRepository gamerRepository){
        this.gamerRepository = gamerRepository;
    }

    @GetMapping("/findAll")
    public List<Gamer>getAll(){
        log.info("Find all: {\n}",gamerRepository.findAll());
        return gamerRepository.findAll();
    }

    @GetMapping("/findBy/{id}")
    public Gamer getById(@PathVariable Long id){
        log.info("Find game: {}",gamerRepository.findById(id));
        return gamerRepository.findById(id).orElse(null);
    }
    @PostMapping("/save")
    public void save(@RequestBody Gamer gamer){
        gamerRepository.save(gamer);
        log.info("Save user: {}",gamerRepository.findById(gamer.getId()));
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id,@RequestBody Gamer gamer){
        if(!gamerRepository.findById(id).isEmpty()){
            gamerRepository.save(gamer);
            log.info("Update user: {}",gamerRepository.findById(gamer.getId()));
        }else log.info("Not find id");
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        log.info("Delete user: {}",gamerRepository.findById(id));
        gamerRepository.deleteById(id);
    }
}
