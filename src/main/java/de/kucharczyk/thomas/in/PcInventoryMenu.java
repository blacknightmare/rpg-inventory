package de.kucharczyk.thomas.in;

import de.kucharczyk.thomas.domain.inventory.Bag;
import de.kucharczyk.thomas.in.BaseInventoryInteractions;
import de.kucharczyk.thomas.in.InventoryInteractor;
import de.kucharczyk.thomas.service.InventoryService;

import java.util.Scanner;

public class PcInventoryMenu extends BaseInventoryInteractions implements InventoryInteractor {

//    private int userId = 14;

    public boolean validateUserId (int userId) {
        if(userId <= -1) {
            throw new IllegalArgumentException("User ID has to be positive.");
        } else {
            return true;
        }
    }

    @Override
    public void run(int pcId) {
        if(validateUserId(pcId)) {

            InventoryService invService = new InventoryService(pcId);
            boolean running = true;
            Scanner scanner = new Scanner(System.in);

            while (running) {
                printOptions();

                int numberSelection = scanner.nextInt();
//            System.out.println("second");
                scanner.nextLine();

                if (numberSelection == 1) {

                    System.out.println("Showing bags");
                    if (currentPc.getBagList().isEmpty()) {
                        System.out.println("PC carries no bags.");
                    } else {
                        for (Bag tempBag : currentPc.getBagList()) {
                            System.out.println("Bag ID: " + tempBag.getBagId() + " - Name: " + tempBag.getName());
                        }
                    }
                }

                if (numberSelection == 2) {
                    scanner.nextLine();
                    System.out.println("Enter a bag name");
                    String bagName = scanner.nextLine();
//                scanner.nextLine();
//                System.out.println("Enter value" + bagName);
                    createBag(currentPc, bagName);


                }

                if (numberSelection == 3) {
                    System.out.println("Enter Bag ID:");
                    int bagSelection = scanner.nextInt();
                    if (currentPc.findBagById(bagSelection) != null) {
                        Bag currentBag = currentPc.findBagById(bagSelection);
                        System.out.println("Adding new item to bag");
                        scanner.nextLine();
                        System.out.println("Enter a Name:");
                        String itemName = scanner.nextLine();
//                    System.out.println("entered name: " + itemName);
//                    scanner.nextLine();
                        System.out.println("Enter a description:");
                        String itemDesc = scanner.nextLine();
//                    scanner.nextLine();
                        System.out.println("Enter a weight (double):");
                        double itemWeight = scanner.nextDouble();
                        scanner.nextLine();
                        if (createItem(currentBag, itemName, itemDesc, itemWeight)) {
                            System.out.println("Finished putting it in.");
                        } else {
                            System.out.println("Something did go wrong. Did you really have an item?");
                        }

                    } else {
                        System.out.println("There is no bag with this in this characters possession");
                    }
                }

                if (numberSelection == 4) {
                    System.out.println("Enter bag id to view content:");
                    int bagSelection = scanner.nextInt();
                    showBagContent(currentPc, bagSelection);
                }

                if (numberSelection == 5) {
                    System.out.println("Choose a bag:");
                    int bagSelection = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Choose the item to delete:");
                    int itemSelection = scanner.nextInt();
                    deleteItemFromBag(currentPc, bagSelection, itemSelection);
                }

                if (numberSelection == 0) {
                    System.out.println("Exiting bag editor.");
//                session.close();
                    running = false;
                }

            }
        }

    }
}
