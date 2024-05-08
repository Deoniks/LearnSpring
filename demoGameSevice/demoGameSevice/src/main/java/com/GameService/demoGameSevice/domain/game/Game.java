package com.GameService.demoGameSevice.domain.game;

import com.GameService.demoGameSevice.domain.user.Gamer;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "GAME")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int ageLimite;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "genre_id",referencedColumnName = "id")
    private Genre genre;

    /*@OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id",referencedColumnName = "id")
    private List<Gamer> gamers;*/

    public Game(String name, int ageLimite, Genre genre) {
        this.name = name;
        this.ageLimite = ageLimite;
        this.genre = genre;
    }

    public Game(Long id, String name, int ageLimite, Genre genre) {
        this.id = id;
        this.name = name;
        this.ageLimite = ageLimite;
        this.genre = genre;
    }

    /*public Game(String name, int ageLimite, Genre genre, List<Gamer> gamers) {
        this.name = name;
        this.ageLimite = ageLimite;
        this.genre = genre;
        this.gamers = gamers;
    }

    public Game(Long id, String name, int ageLimite, Genre genre, List<Gamer> gamers) {
        this.id = id;
        this.name = name;
        this.ageLimite = ageLimite;
        this.genre = genre;
        this.gamers = gamers;
    }

    public void addGame(Gamer gamer){
        this.gamers.add(gamer);
    }*/
}
