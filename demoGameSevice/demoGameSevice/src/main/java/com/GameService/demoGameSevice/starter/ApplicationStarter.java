package com.GameService.demoGameSevice.starter;

import com.GameService.demoGameSevice.domain.game.Game;
import com.GameService.demoGameSevice.domain.game.Genre;
import com.GameService.demoGameSevice.domain.user.Gamer;
import com.GameService.demoGameSevice.service.game.GameService;
import com.GameService.demoGameSevice.service.game.GenreService;
import com.GameService.demoGameSevice.service.user.GamerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApplicationStarter implements CommandLineRunner{
    @Autowired
    private GameService gameService;
    @Autowired
    private GenreService genreService;
    @Autowired
    private GamerService gamerService;

    @Override
    public void run(String... args) throws Exception {

        Genre action = new Genre("Action");
        Genre rpg = new Genre("Rpg");
        Genre strategy = new Genre("Strategy");


        genreService.save(action);
        genreService.save(rpg);
        genreService.save(strategy);

        genreService.getById(2L);

        rpg.setNameGenre("RPG");

        genreService.update(2L,rpg);
        genreService.getAll();

        Game doom = new Game("Doom",18,action);
        Game hl = new Game("half-life",18,action);
        Game theWitcher = new Game("The witcher",18,rpg);
        Game cossacks = new Game("Casaki",12,strategy);


        gameService.save(doom);
        gameService.save(hl);
        gameService.save(theWitcher);
        gameService.save(cossacks);


        cossacks.setName("cossacks");
        gameService.update(3L,cossacks);

        gameService.delete(cossacks);
        genreService.delete(strategy);

        genreService.update(3L,strategy);
        gameService.update(3L,cossacks);

        List<Game>games = new ArrayList<>();
        games.add(doom);
        games.add(theWitcher);

        Gamer deo = new Gamer("Deo","Dmitry",21,games);
        Gamer deos = new Gamer("Deos","Dms",22,games);
        Gamer desos = new Gamer("Desos","Ddes",32);


        gamerService.save(deos);
        gamerService.save(deo);
        gamerService.save(desos);

        gameService.buyGame(1L,deo);
        gameService.buyGame(1L,deos);


        //gameService.buyGame(2L,deos);
    }
}
