package de.kucharczyk.thomas.inventory;

import de.kucharczyk.thomas.roles.PlayerCharacter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BagTest {

    final String name = "testBag";
    final int size = 100;
    private final Bag testBag = new Bag(name, size);


    @Test
    void bagCreationWorks() {
        assertThat(testBag.getName()).isEqualTo(name);
        assertThat(testBag.getSize()).isEqualTo(size);

    }

    @Test
    void setPlayerCharacter() {
        PlayerCharacter playerMock = mock(PlayerCharacter.class);
        when(playerMock.getCharacterId()).thenReturn(10);
        when(playerMock.getName()).thenReturn("MockUser");
//        System.out.println("playerMock ID: " + playerMock.getCharacterId());
//        System.out.println("playerMock Name: " + playerMock.getName());
        testBag.setPlayerCharacter(playerMock);
        assertEquals(playerMock, testBag.getPlayerCharacter());
    }

    @Test
    void getItemList() {
        ItemMundane testItemOne = new ItemMundane("itemOne", "test item one", 50.89);
        ItemMundane testItemTwo = new ItemMundane("itemTwo", "test item two", 2.42);
        ItemMundane testItemThree = new ItemMundane("itemThree", "test item three", 4.6);
        testBag.add(testItemOne);
        testBag.add(testItemTwo);

        assertThat(testBag.getItemList()).contains(testItemOne, testItemTwo);
//        assertThat(testBag.getItemList()).contains(testItemOne, testItemTwo, testItemThree);
    }

    @Test
    void add() {
        ItemMundane testItemOne = new ItemMundane("itemOne", "test item one", 50.89);
        testBag.add(testItemOne);
        assertThat(testBag.getItemList()).contains(testItemOne);
    }

    @Test
    void findItemById() {
        ItemMundane mockItem = mock(ItemMundane.class);
        when(mockItem.getItemId()).thenReturn(4);
        when(mockItem.getName()).thenReturn("mockItem");
        when(mockItem.getWeight()).thenReturn(4.48);
        testBag.add(mockItem);

        assertEquals(mockItem, testBag.findItemById(4));
    }
}