package de.kucharczyk.thomas;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);


        CharacterInteraction interactor = new CharacterInteraction();
        boolean running = true;

        do
        {
        System.out.println("\n ============================== \n");
        System.out.println("Logged in as User with ID 14:");
        System.out.println("______________________________");
        System.out.println("Action List:");
        System.out.println("1 = List assigned Characters");
        System.out.println("2 = create new NPC");
        System.out.println("3 = create new PC");
//        System.out.println("4 = Edit Inventory of NPC");
        System.out.println("5 = Edit Inventory of PC");
        System.out.println("0 = Exit");


        int numberSelection = scanner.nextInt();
            scanner.nextLine();

            switch (numberSelection) {
                case 1:
                    System.out.println(interactor.listCharacters());
                    break;
                case 2:
//                    scanner.nextLine();
                    System.out.println("Enter a Name for the NPC:");
                    String stringInputNPC = scanner.nextLine();
//                    scanner.nextLine();
                    interactor.createNPC(stringInputNPC);
                    break;
                case 3:
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
                    interactor.createPC(stringInputPCName, intInputPC, stringInputPCRace);
                    break;
                case 4:
//                    scanner.nextLine();
                    System.out.println("Trying to use editor");
                    interactor.editInventoryNPC(14, 18);
                    System.out.println();
                    break;
                case 5:
//                    scanner.nextLine();
//                    System.out.println("Trying to use PC bag editor");
                    System.out.println("Give the PC ID:");
                    int selectedCharacterId = scanner.nextInt();
                    interactor.editInventoryPC(14, selectedCharacterId);
                    System.out.println();
                    break;
                case 0:
                    running = false;
                    scanner.close();
                    break;
            }
        }
        while(running);

        System.out.println("Shutting down");
    }

//    public void test(Item item) {
//        if(item instanceof ItemAttack) {
//            ((ItemAttack) item).addAttackProperties("fuvbd");
//        }
//    }

}
