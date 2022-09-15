package de.kucharczyk.thomas.service;

import de.kucharczyk.thomas.User;
import de.kucharczyk.thomas.domain.inventory.Bag;
import de.kucharczyk.thomas.domain.inventory.ItemMundane;
import de.kucharczyk.thomas.in.BaseInventoryInteractions;
import de.kucharczyk.thomas.domain.roles.PlayerCharacter;
import de.kucharczyk.thomas.out.Repository;

import java.util.Scanner;

public class InventoryService {

    private int pcId;
    public InventoryService(int pcId) {
        if(pcId > -1) {
            this.pcId = pcId;
        } else {
            throw new IllegalArgumentException("User ID has to be positive.");
        }
    }

    public void listBags(int pcId) {
        Repository repository = new Repository();
        repository.open();
        PlayerCharacter pc = repository.getPCById(pcId);
        if(pc != null) {
            for (Bag tempBag : pc.getBagList()) {
                System.out.println("Bag ID: " + tempBag.getBagId() + " - Name: " + tempBag.getName());
            }
        }
    }

    public void createBag(int pcId, String bagName) {
        if (!bagName.isBlank()) {

            try {

                Repository repository = new Repository();
                repository.open();
                PlayerCharacter pc = repository.getPCById(pcId);

                Bag newBag = new Bag(bagName);

                pc.add(newBag);

                repository.save(pc);

                System.out.println(newBag.getBagId() + " - " + newBag.getName());

                repository.close();

            } finally {
//                session.close();
            }
        } else {
            System.out.println("no name entered");
        }
    }

    public boolean createItem(int pcId, int bagId, String name, String description, double weight) {
        if (name.isBlank() || weight == 0 ||
                description.isBlank())
        {
            System.out.println("name:" + name + "\n" +
                    "desc: " + description + "\n" +
                    "weight: " + weight);
            System.out.println("Missing parameters!");
            return false;
        } else {
            try {
                Repository repository = new Repository();
                repository.open();
                PlayerCharacter pc = repository.getPCById(pcId);
                Bag currentBag = pc.findBagById(bagId);

                ItemMundane newItem = new ItemMundane(name, description, weight);

                currentBag.add(newItem);

                repository.save(currentBag);

                System.out.println(newItem.getItemId());

                repository.close();

                System.out.println("Item(ID: " + newItem.getItemId() + ") with name: " + newItem.getName() + " created.");

            } finally {
//                session.close();
            }
            return true;
        }
    }

    private void showBagContent(int pcId, int bagSelection) {
        Repository repository = new Repository();
        repository.open();

        if(repository.getPCById(pcId) != null) {
            PlayerCharacter pc = repository.getPCById(pcId);
            Bag currentBag = pc.findBagById(bagSelection);

            if(!currentBag.getItemList().isEmpty()) {
                System.out.println("Showing content list:");
                for (ItemMundane tempItem : currentBag.getItemList()
                ) {
                    System.out.println(tempItem.toString() + "\n");
                }
            } else {
                System.out.println("No items in bag.");
            }

        }
    }

    private void deleteItemFromBag(int pcId, int bagSelection, int itemSelection) {
        Repository repository = new Repository();
        repository.open();
        PlayerCharacter pc = repository.getPCById(pcId);

        if(bagSelection > -1 && pc.findBagById(bagSelection) != null) {
            Bag currentBag = pc.findBagById(bagSelection);

            if (itemSelection > -1 && currentBag.findItemById(itemSelection) != null) {
                ItemMundane tempItem = currentBag.findItemById(itemSelection);


                try {

                    boolean isRemoved = currentBag.getItemList().remove(tempItem);

                    if(isRemoved) {
                        repository.delete(tempItem);
                        repository.save(currentBag);
                    }
                    else {
                        System.out.println("Error. could not remove the item!");
                    }

                } finally {
//                    session.close();
                }

            } else {
                System.out.println("no corresponding item found.");
            }
        }
    }



}
