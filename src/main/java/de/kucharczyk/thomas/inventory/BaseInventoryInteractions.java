package de.kucharczyk.thomas.inventory;

public abstract class BaseInventoryInteractions {

    public void printInteractions() {
            System.out.println("==========================");
            System.out.println("Inventory options:");
            System.out.println("1. Show Bags");
            System.out.println("2. Create Bag");
            System.out.println("3. Put Item in Bag");
            System.out.println("4. Show items in bag");
            System.out.println("5. Delete item from bag");
            System.out.println("6. Exit");
    }
}
