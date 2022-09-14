package de.kucharczyk.thomas;

import de.kucharczyk.thomas.roles.PlayerCharacter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlayerCharacterFactory {

    private NameConverter converter;


    public PlayerCharacter createDefaultPC(String name) {
        String s = converter.convertName(name);
        return new PlayerCharacter(s, 120, "Human");
    }
}
