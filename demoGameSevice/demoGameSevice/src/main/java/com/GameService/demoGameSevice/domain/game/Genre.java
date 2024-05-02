package com.GameService.demoGameSevice.domain.game;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "GENRE")
public class Genre{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameGenre;

    public Genre(String nameGenre) {
        this.nameGenre = nameGenre;
    }

    public Genre(Long id, String nameGenre) {
        this.id = id;
        this.nameGenre = nameGenre;
    }
}
