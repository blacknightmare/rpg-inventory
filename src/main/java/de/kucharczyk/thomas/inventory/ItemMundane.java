package de.kucharczyk.thomas.inventory;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class ItemMundane extends Item{

    public ItemMundane(String name, String description, double weight) {
        super(name, description, weight, ItemType.MUNDANE);

    }

    public ItemMundane() {
        super("name", "description", 0, ItemType.MUNDANE);
    }

}
