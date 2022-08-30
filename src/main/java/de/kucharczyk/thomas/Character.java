package de.kucharczyk.thomas;

import com.sun.istack.NotNull;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_character;

    @NotNull
    private String name;

    @NotNull
    private String race;

    @ColumnDefault("10")
    private int weight;


    private int FK_character_user;


}
