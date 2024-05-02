package com.GameService.demoGameSevice.service.user;

import com.GameService.demoGameSevice.domain.user.Gamer;

import java.util.List;

public interface GamerService {
    List<Gamer> getAll();
    void save(Gamer gamer);
    void update(Long id,Gamer gamer);
    void delete(Gamer gamer);
    void buyGame(Long id,Gamer gamer);
    Gamer getById(Long id);
}
