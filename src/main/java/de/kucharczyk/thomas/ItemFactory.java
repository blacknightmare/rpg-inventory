package de.kucharczyk.thomas;

import de.kucharczyk.thomas.inventory.Item;
import de.kucharczyk.thomas.inventory.ItemAttack;
import de.kucharczyk.thomas.inventory.ItemMundane;
import de.kucharczyk.thomas.inventory.ItemType;

public class ItemFactory {

    public Item createItem(String givenType, String name, String description, double weight) {

//        for (ItemType type : ItemType.values()) {
//            if(type.toString().equalsIgnoreCase(givenType) ) {
//
//            }
//        }

        if (givenType.equalsIgnoreCase(ItemType.MUNDANE.toString())) {
            return new ItemMundane(name, description, weight);
        } else {
            return null;
        }
//        else if (givenType.equalsIgnoreCase(ItemType.WEAPON.toString())) {
//            return new ItemAttack(name, description, weight);
//        }
    }
}
