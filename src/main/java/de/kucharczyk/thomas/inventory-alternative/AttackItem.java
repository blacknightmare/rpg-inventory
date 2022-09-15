package de.kucharczyk.thomas.inventory;

import de.kucharczyk.thomas.domain.inventory.Item;
import de.kucharczyk.thomas.domain.inventory.ItemType;

public class AttackItem extends Item {

    public AttackItem(String name, String description, double weight, ItemType type) {
        super(name, description, weight, type);
    }
}
