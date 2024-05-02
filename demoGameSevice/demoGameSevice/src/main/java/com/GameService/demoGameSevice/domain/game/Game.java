package com.GameService.demoGameSevice.domain.game;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "GAME")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int ageLimite;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

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
