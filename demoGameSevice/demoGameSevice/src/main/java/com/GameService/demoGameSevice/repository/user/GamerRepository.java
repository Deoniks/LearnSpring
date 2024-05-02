package com.GameService.demoGameSevice.repository.user;

import com.GameService.demoGameSevice.domain.user.Gamer;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface GamerRepository extends JpaRepository<Gamer,Long> {
}
