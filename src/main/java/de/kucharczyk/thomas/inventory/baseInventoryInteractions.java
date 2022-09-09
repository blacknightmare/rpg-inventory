package de.kucharczyk.thomas.inventory;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public abstract class baseInventoryInteractions {

    public void printInteractions() {
            System.out.println("==========================");
            System.out.println("Inventory options:");
            System.out.println("1. Show Bags");
            System.out.println("2. Put Item in Bag");
            System.out.println("3. Exit");
    }
}
