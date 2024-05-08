package com.GameService.demoGameSevice.domain.user;

import com.GameService.demoGameSevice.domain.game.Game;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "GAMER")
public class Gamer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String name;
    private int age;

    @OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id",referencedColumnName = "id")
    private List<Game> games;

    public Gamer(String login, String name, int age) {
        this.login = login;
        this.name = name;
        this.age = age;
        //this.games = new ArrayList<>();
    }

    public Gamer(String login, String name, int age, List<Game> games) {
        this.login = login;
        this.name = name;
        this.age = age;
        this.games = games;
    }

    public Gamer(Long id, String login, String name, int age, List<Game> games) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.age = age;
        this.games = games;
    }

    /*public void addGame(Game game){
        games.add(game);
    }*/
}
