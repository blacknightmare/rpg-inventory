package de.kucharczyk.thomas;

import de.kucharczyk.thomas.inventory.Bag;
import de.kucharczyk.thomas.inventory.ItemMundane;
import de.kucharczyk.thomas.inventory.baseInventoryInteractions;
import de.kucharczyk.thomas.inventory.pcInventoryInteractor;
import de.kucharczyk.thomas.roles.Npc;
import de.kucharczyk.thomas.roles.PlayerCharacter;
import org.hibernate.MultiIdentifierLoadAccess;
import org.hibernate.Session;

import java.util.Scanner;

public class characterInteraction {

    private int userId = 14;
//    private int userId = 8;

    public void createNPC(String name) {
        if (name.isBlank()) {
            System.out.println("Missing parameters!");
        } else {
                Session session = HibernateUtil.getSessionFactory().openSession();
            try {
                session.beginTransaction();

                User tempUser = session.get(User.class, userId);
                Npc newNpc = new Npc(name);
                tempUser.add(newNpc);
                session.save(tempUser);

                System.out.println(newNpc.getId());

                session.getTransaction().commit();

                System.out.println("NPC(ID: " +newNpc.getId() + ") with name: " + newNpc.getName() + " created.");

            } catch (Exception e) {
                System.out.println("something was wrong!");
                e.printStackTrace();
            } finally {
                session.close();
            }
        }
    }

    public void createPC(String name, int carryWeight, String race) {
        if (name.isBlank() || carryWeight == 0 ||
                race.isBlank())
//                EnumUtils.isValidEnum(Race.class, race))
        {
            System.out.println("Missing parameters!");
        } else {
            Session session = HibernateUtil.getSessionFactory().openSession();
            try {
                session.beginTransaction();

                User tempUser = session.get(User.class, userId);
                PlayerCharacter newPc = new PlayerCharacter(name, carryWeight, race);

                tempUser.add(newPc);

                session.save(tempUser);

                System.out.println(newPc.getCharacterId());

                session.getTransaction().commit();

                System.out.println("PC(ID: " + newPc.getCharacterId() + ") with name: " + newPc.getName() + " created.");

            } finally {
                session.close();
            }
        }
    }

    public String listCharacters() {

        String characterList = "";

        Session session = HibernateUtil.getSessionFactory().openSession();

        User tempUser = session.get(User.class, userId);

        if(!tempUser.getNpcList().isEmpty()) {
            characterList = "NPCs: \n";
            for (Npc tempNPC : tempUser.getNpcList()
            ) {
                characterList += tempNPC.getId() + " - " + tempNPC.getName() + "\n";

            }
        }

        if(!tempUser.getCharacters().isEmpty()) {
            characterList += "Player Characters: \n";
            for (PlayerCharacter tempPC : tempUser.getCharacters()
            ) {
                characterList += tempPC.getCharacterId() + " - " + tempPC.getName() + "\n";

            }

        }


        session.close();

        return characterList;
    }

    public void editInventoryNPC(int userId, int characterId) {
        Session session = HibernateUtil.getSessionFactory().openSession();


        User tempUser = session.get(User.class, userId);

        if(tempUser == null) {
            System.out.println("no user found.");
            return;
        }

        Npc currentNpc = tempUser.findNpcById(characterId);
        if(currentNpc == null) {
            System.out.println("No corresponding character found!");
            return;
        } else {

        }


        if(tempUser != null) {
            System.out.println("user found");
        } else {
            System.out.println("no NPC found!");
        }

//        try {
//            Npc tempNpc = session.get(Npc.class, characterId);
//        } catch (Exception e) {
//            System.out.println("no NPC found");
//        }
        session.getTransaction().commit();
        session.close();

    }

    public void editInventoryPC(int userId, int characterId) {
        Session session = HibernateUtil.getSessionFactory().openSession();


        User tempUser = session.get(User.class, userId);

        if(tempUser == null) {
            System.out.println("no user found.");
            return;
        }

        PlayerCharacter currentPc = tempUser.findPCById(characterId);
        if(currentPc == null) {
            System.out.println("No corresponding character found!");
            return;
        } else {
            pcInventoryInteractor pcInteractor = new pcInventoryInteractor();
            interactionHandler(pcInteractor, currentPc);
        }


        if(tempUser != null) {
            System.out.println("user found");
        } else {
            System.out.println("no NPC found!");
        }

        session.getTransaction().commit();
        session.close();
    }

    private void interactionHandler(baseInventoryInteractions interactor, PlayerCharacter currentPc) {

        Scanner scanner = new Scanner(System.in);
        boolean active = true;

        do
        {
            scanner.nextLine();
            interactor.printInteractions();
            int numberSelection = scanner.nextInt();

            if(numberSelection == 1) {
                System.out.println("Showing bags");
                if (currentPc.getBagList().isEmpty()) {
                    System.out.println("PC carries no bags.");
                } else {
                    for (Bag tempBag : currentPc.getBagList()) {
                        System.out.println("Bag ID: "+ tempBag.getBagId() + " - Name: " +tempBag.getName());
                    }
                }
            }

            if(numberSelection == 2) {
                System.out.println("Enter Bag ID:");
                int bagSelection = scanner.nextInt();
                if (currentPc.findBagById(bagSelection) != null) {
                    Bag currentBag = currentPc.findBagById(bagSelection);
                    System.out.println("Adding new item to bag");
                    System.out.println("Enter a Name:");
                    String itemName = scanner.nextLine();
                    scanner.nextLine();
                    String itemDesc = scanner.nextLine();
                    scanner.nextLine();
                    double itemWeight = scanner.nextDouble();
                    scanner.nextLine();
                    if(createItem(currentBag, itemName, itemDesc, itemWeight)) {
                        System.out.println("Finished putting it in.");
                    } else {
                        System.out.println("Something did go wrong. Did you really have an item?");
                    }

                } else {
                    System.out.println("There is no bag with this in this characters possession");
                }
            }

            if(numberSelection == 3) {
                System.out.println("Enter bag id to view content:");
                int bagSelection = scanner.nextInt();
                showBagContent(currentPc, bagSelection);
            }

            if(numberSelection == 4) {
                System.out.println("Choose a bag:");
                int bagSelection = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Choose the item to delete:");
                int itemSelection = scanner.nextInt();
                deleteItemFromBag(currentPc, bagSelection, itemSelection);
            }

            if(numberSelection == 5) {
                System.out.println("Exiting bag editor.");
                active = false;
            }

        } while(active);
    }

    private void deleteItemFromBag(PlayerCharacter currentPc, int bagSelection, int itemSelection) {
        if(bagSelection > -1 && currentPc.findBagById(bagSelection) != null) {
            Bag currentBag = currentPc.findBagById(bagSelection);

            if (itemSelection > -1 && currentBag.findItemById(itemSelection) != null) {
                ItemMundane tempItem = currentBag.findItemById(itemSelection);

                Session session = HibernateUtil.getSessionFactory().openSession();

                try {
                    session.beginTransaction();

                    boolean isRemoved = currentBag.getItemList().remove(tempItem);

                    if(isRemoved) {
                        session.save(currentBag);
                    }
                    else {
                        System.out.println("Error. could not remove the item!");
                    }

                    session.getTransaction().commit();
                } finally {
                    session.close();
                }

            } else {
                System.out.println("no corresponding item found.");
            }
        }
    }

    private void showBagContent(PlayerCharacter currentPc, int bagSelection) {
        if(currentPc.findBagById(bagSelection) != null) {
            Bag currentBag = currentPc.findBagById(bagSelection);
            System.out.println("Showing content list:");

            for (ItemMundane tempItem : currentBag.getItemList()
                 ) {
                System.out.println(tempItem.toString() + "\n");

            }
        }
    }

    public boolean createItem(Bag currentBag, String name, String description, double weight) {
        if (name.isBlank() || weight == 0 ||
                description.isBlank())
        {
            System.out.println("Missing parameters!");
            return false;
        } else {
            Session session = HibernateUtil.getSessionFactory().openSession();
            try {
                session.beginTransaction();

                ItemMundane newItem = new ItemMundane(name, description, weight);

                currentBag.add(newItem);

                session.save(currentBag);

                System.out.println(newItem.getItemId());

                session.getTransaction().commit();

                System.out.println("Item(ID: " + newItem.getItemId() + ") with name: " + newItem.getName() + " created.");

            } finally {
                session.close();
            }
            return true;
        }
    }


    public boolean isValidEnum(String race) {
        // foreach
        return false;
    }


}
