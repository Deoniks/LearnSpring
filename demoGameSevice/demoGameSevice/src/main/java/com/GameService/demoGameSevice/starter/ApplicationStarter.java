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

        Genre action1 = new Genre("Action");
        Genre rpg1 = new Genre("Rpg");
        Genre strategy1= new Genre("Strategy");

        genreService.save(action);
        genreService.save(rpg);
        genreService.save(strategy);

        genreService.save(action1);
        genreService.save(rpg1);
        genreService.save(strategy1);

        genreService.getById(2L);

        rpg.setNameGenre("RPG");

        genreService.update(2L,rpg);
        genreService.getAll();

        Game doom = new Game("Doom",18,action);
        Game theWitcher = new Game("The witcher",18,rpg);
        Game cossacks = new Game("Casaki",12,strategy);

        Game doom1 = new Game("Doom",18,action1);
        Game theWitcher1 = new Game("The witcher",18,rpg1);
        Game cossacks1 = new Game("Casaki",12,strategy1);

        gameService.save(doom);
        gameService.save(theWitcher);
        gameService.save(cossacks);

        gameService.save(doom1);
        gameService.save(theWitcher1);
        gameService.save(cossacks1);

        cossacks.setName("cossacks");
        gameService.update(3L,cossacks);

        gameService.delete(cossacks);
        genreService.delete(strategy);

        genreService.update(3L,strategy);
        gameService.update(3L,cossacks);
        List<Game>games = new ArrayList<>();
        games.add(doom);
        games.add(theWitcher);

        List<Game>games1 = new ArrayList<>();
        games1.add(doom1);
        games1.add(theWitcher1);

        Gamer deo = new Gamer("Deo","Dmitry",21,games);
        Gamer deos = new Gamer("Deos","Dms",22,games1);
        Gamer desos = new Gamer("Desos","Ddes",32,games);

        /*deo.addGame(doom);
        deo.addGame(theWitcher);


        deos.addGame(doom);
        deos.addGame(theWitcher);

        desos.addGame(doom);
        desos.addGame(theWitcher);*/



        gamerService.save(deos);
        gamerService.save(deo);
        gamerService.save(desos);
        //gamerService.buyGame(2L,deo);

    }
}
