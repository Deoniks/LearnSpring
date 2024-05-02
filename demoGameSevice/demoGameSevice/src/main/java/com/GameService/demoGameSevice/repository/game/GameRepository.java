package com.GameService.demoGameSevice.repository.game;

import com.GameService.demoGameSevice.domain.game.Game;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface GameRepository extends JpaRepository<Game, Long> {
}

