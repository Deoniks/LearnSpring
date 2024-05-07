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
    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "genre_id",referencedColumnName = "id")
    private Genre genre;
    /*@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "gamer_id",referencedColumnName = "id")
    private Gamer gamer;*/

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


}
