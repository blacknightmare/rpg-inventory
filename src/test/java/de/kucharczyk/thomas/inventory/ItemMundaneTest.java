package de.kucharczyk.thomas.inventory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.Table;

import static org.junit.jupiter.api.Assertions.*;

class ItemMundaneTest {

    private final ItemMundane mundane = new ItemMundane("mundaneItem", "just a normal item", 2.5);

    @Test
    @DisplayName("test if item can be created")
    public void testItem() {
        assertNotNull(mundane);
    }

    @Test
    @DisplayName("check if params were set")
    void checkParams() {
        // Given
        final String name = "mundaneItem";
        final String description = "just a normal item";
        final double weight = 2.5;

        // When
        final ItemMundane mundane = new ItemMundane(name, description, weight);

        // Then
        assertAll("mundane",
                () -> assertEquals(name, mundane.getName()),
                () -> assertEquals(description, mundane.getDescription()),
                () -> assertEquals(weight, mundane.getWeight()),
                () -> assertEquals(ItemType.MUNDANE, mundane.getType())
                );
    }

    @Test
    @DisplayName("check if default constructor works")
    void defaultItemMundaneWorking() {
        ItemMundane defaultMundane = new ItemMundane();
        assertAll("default item",
                () -> assertThat(defaultMundane).isInstanceOf(Item.class),
                () -> assertEquals("name", defaultMundane.getName()),
                () -> assertEquals("description", defaultMundane.getDescription()),
                () -> assertEquals(0, defaultMundane.getWeight()),
                () -> assertEquals(ItemType.MUNDANE, defaultMundane.getType())
                );
    }

    @Test
    @DisplayName("try adding a bag")
    void canAddBagToItem() {
        Bag testBag = new Bag("test");
        assertAll("setting bag",
                () -> {
                        mundane.setBag(testBag);
                        assertThat(mundane.getBag()).isInstanceOf(Bag.class);
                    }

                );
    }
}