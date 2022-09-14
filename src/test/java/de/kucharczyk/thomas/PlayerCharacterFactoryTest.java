package de.kucharczyk.thomas;

import de.kucharczyk.thomas.roles.PlayerCharacter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlayerCharacterFactoryTest{
    @InjectMocks
    private PlayerCharacterFactory factory;

    @Mock
    private NameConverter converter;

    @Test
    public void pcFactoryTest() {
        // GIVEN
        String name = "Tester";
        when(converter.convertName(any())).thenReturn("TESTER");

        // WHEN
        PlayerCharacter result = factory.createDefaultPC(name);

        //THEN
        assertThat(result.getCarryWeight()).isEqualTo(120);
    }
}