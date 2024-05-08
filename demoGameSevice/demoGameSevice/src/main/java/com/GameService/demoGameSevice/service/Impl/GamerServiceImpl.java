package com.GameService.demoGameSevice.service.Impl;

import com.GameService.demoGameSevice.domain.user.Gamer;
import com.GameService.demoGameSevice.repository.game.GameRepository;
import com.GameService.demoGameSevice.repository.user.GamerRepository;
import com.GameService.demoGameSevice.service.user.GamerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GamerServiceImpl implements GamerService {

    private Logger log = LoggerFactory.getLogger(GameServiceImpl.class);

    @Autowired
    private GamerRepository gamerRepository;
    @Autowired
    private GameRepository gameRepository;

    @Override
    public List<Gamer> getAll() {
        log.info("find all: {}",gamerRepository.findAll());
        return gamerRepository.findAll();
    }

    @Override
    public void save(Gamer gamer) {
        gamerRepository.save(gamer);
        log.info("Save user: {}",gamerRepository.findById(gamer.getId()));
    }

    @Override
    public void update(Long id, Gamer gamer) {
        if(!gamerRepository.findById(id).isEmpty()){
            gamerRepository.save(gamer);
        }else log.info("Update user: {}",gamerRepository.findById(gamer.getId()));
    }

    @Override
    public void delete(Gamer gamer) {
        log.info("Delete user:{}",gamerRepository.findById(gamer.getId()));
        gamerRepository.delete(gamer);
    }

    /*@Override
    public void buyGame(Long id,Gamer gamer) {
        gamer.addGame(gameRepository.findById(id).orElse(null));
        log.info("buy game: {}",gamerRepository.findById(gamer.getId()));
    }*/

    @Override
    public Gamer getById(Long id) {
        log.info("Find user: {}",gamerRepository.findById(id));
        return gamerRepository.findById(id).orElse(null);
    }


}
