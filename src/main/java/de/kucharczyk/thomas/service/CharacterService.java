package de.kucharczyk.thomas.service;

import de.kucharczyk.thomas.User;
import de.kucharczyk.thomas.domain.inventory.Bag;
import de.kucharczyk.thomas.domain.inventory.ItemMundane;
import de.kucharczyk.thomas.in.BaseInventoryInteractions;
import de.kucharczyk.thomas.domain.roles.Npc;
import de.kucharczyk.thomas.domain.roles.PlayerCharacter;
import de.kucharczyk.thomas.in.PcInventoryMenu;
import de.kucharczyk.thomas.out.Repository;

import java.util.Scanner;

public class CharacterService {
    private int userId;
//    private Repository repository;

    public CharacterService(int userId) {
        if(userId > -1) {
        this.userId = userId;

//            repository.setUserById(userId);
//            repository.open();
        } else {
            throw new IllegalArgumentException("User ID has to be positive.");
        }
    }



    public void createNPC(String name) {
        if (name.isBlank()) {
            System.out.println("Missing parameters!");
        } else {
            try {
//                session.beginTransaction();
//
//                User tempUser = session.get(User.class, userId);
//                Npc newNpc = new Npc(name);
//                tempUser.add(newNpc);
//                session.save(tempUser);
//
//                System.out.println(newNpc.getId());
//
//                session.getTransaction().commit();
//
//                User currentUser = pcRepository.getCurrentUser();
//                pcRepository.save(currentUser);
//
//
//
//
//
//                System.out.println("NPC(ID: " +newNpc.getId() + ") with name: " + newNpc.getName() + " created.");

            } catch (Exception e) {
                System.out.println("something was wrong!");
                e.printStackTrace();
            } finally {
//                session.close();
            }
        }
    }

    public void createPC(int userId, String name, int carryWeight, String race) {
        if (name.isBlank() || carryWeight <= 0 ||
                race.isBlank() || userId < 0)
//                EnumUtils.isValidEnum(Race.class, race))
        {
//            System.out.println("Missing parameters!");
            throw new IllegalArgumentException("parameters are wrong or empty.");
        } else {
            try {

//                PlayerCharacter c = PlayerCharacter.builder().name(name).carryWeight(3).race("test").build();

                PlayerCharacter newPc = new PlayerCharacter(name, carryWeight, race);

                Repository repository = new Repository();

                repository.open();
                User user = repository.getUserById(userId);
                user.add(newPc);
                repository.save(user);
                repository.close();

                System.out.println("PC(ID: " + newPc.getCharacterId() + ") with name: " + newPc.getName() + " created.");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String listCharactersForUser(int userId) {

        String characterList = "";

        Repository repository = new Repository();
        repository.open();
        User currentUser = repository.getUserById(userId);
        if(!currentUser.getNpcList().isEmpty()) {
            characterList = "NPCs: \n";
            for (Npc tempNPC : currentUser.getNpcList()
            ) {
                characterList += tempNPC.getId() + " - " + tempNPC.getName() + "\n";

            }
        }

        if(!currentUser.getCharacters().isEmpty()) {
            characterList += "Player Characters: \n";
            for (PlayerCharacter tempPC : currentUser.getCharacters()
            ) {
                characterList += tempPC.getCharacterId() + " - " + tempPC.getName() + "\n";

            }

        }
        repository.close();
        return characterList;
    }

    public void editInventoryNPC(int userId, int characterId) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//
//
//        User tempUser = session.get(User.class, userId);
//
//        if(tempUser == null) {
//            System.out.println("no user found.");
//            return;
//        }
//
//        Npc currentNpc = tempUser.findNpcById(characterId);
//        if(currentNpc == null) {
//            System.out.println("No corresponding character found!");
//            return;
//        } else {
//
//        }
//
//
//        if(tempUser != null) {
//            System.out.println("user found");
//        } else {
//            System.out.println("no NPC found!");
//        }
//
////        try {
////            Npc tempNpc = session.get(Npc.class, characterId);
////        } catch (Exception e) {
////            System.out.println("no NPC found");
////        }
//        session.getTransaction().commit();
//        session.close();

    }

    public void editInventoryPC(int userId, int characterId) {

        Repository repository = new Repository();
        repository.open();
        PlayerCharacter currentPc = repository.getUserById(userId).findPCById(characterId);
        if(currentPc == null) {
            System.out.println("No corresponding character found!");
            return;
        } else {
            // TODO change this
            PcInventoryMenu pcInventoryMenu = new PcInventoryMenu();
            pcInventoryMenu.run(characterId);
//            interactionHandler(pcInteractor, currentPc);
        }
    }

    private void interactionHandler(BaseInventoryInteractions interactor, PlayerCharacter currentPc) {

        Scanner scanner = new Scanner(System.in);
        boolean active = true;

    }






    public boolean isValidEnum(String race) {
        // foreach
        return false;
    }


//    public void close() {
//        repository.close();
//    }
}
