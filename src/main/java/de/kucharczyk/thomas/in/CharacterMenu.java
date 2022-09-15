package de.kucharczyk.thomas.in;

import de.kucharczyk.thomas.service.CharacterService;

import java.util.Scanner;

public class CharacterMenu {

    private int userId = 14;


    public CharacterMenu(int userId) {
        if(userId > -1) {
            this.userId = userId;
        } else {
            throw new IllegalArgumentException("User ID has to be positive.");
        }
    }


    private void printOptions() {
        System.out.println("\n ============================== \n");
        System.out.println("Logged in as User with ID " + userId + ":");
        System.out.println("______________________________");
        System.out.println("Action List:");
        System.out.println("1 = List assigned Characters");
//        System.out.println("2 = Delete Character");
//        System.out.println("3 = create new NPC");
        System.out.println("4 = create new PC");
//        System.out.println("5 = Edit Inventory of NPC");
        System.out.println("6 = Edit Inventory of PC");
        System.out.println("0 = Exit");
    }

    public void run() {
        CharacterService characterService = new CharacterService(userId);
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        while(running)
        {
            printOptions();

            int numberSelection = scanner.nextInt();
            scanner.nextLine();

            switch (numberSelection) {
                case 1:
                    // List assigned character
                    System.out.println(characterService.listCharactersForUser(userId));
                    break;
//                case 2:
//                    // TODO delete character
//                    break;
//                case 3:
//                    // create npc
////                    scanner.nextLine();
//                    System.out.println("Enter a Name for the NPC:");
//                    String stringInputNPC = scanner.nextLine();
////                    scanner.nextLine();
//                    characterController.createNPC(stringInputNPC);
//                    break;
                case 4:
                    // create pc
//                    scanner.nextLine();
                    System.out.println("Enter a Name for the PC:");
                    String stringInputPCName = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Enter a carry weight:");
                    int intInputPC = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter a race:");
                    String stringInputPCRace = scanner.nextLine();
                    scanner.nextLine();
                    characterService.createPC(userId, stringInputPCName, intInputPC, stringInputPCRace);
                    break;

 //                   // TODO NPC editor
//                case 5:
////                    scanner.nextLine();
//                    System.out.println("Trying to use editor");
//                    characterController.editInventoryNPC(14, 18);
//                    System.out.println();
//                    break;
                case 6:
                    // edit inventory of pc
//                    scanner.nextLine();
                    System.out.println("Give the PC ID:");
                    int selectedCharacterId = scanner.nextInt();
                    characterService.editInventoryPC(userId, selectedCharacterId);
                    System.out.println();
                    break;
                case 0:
                    // close menu
                    running = false;
                    scanner.close();
//                    characterService.close();
                    break;
            }

    }
}
