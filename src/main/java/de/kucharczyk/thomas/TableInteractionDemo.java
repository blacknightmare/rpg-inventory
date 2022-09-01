package de.kucharczyk.thomas;

import de.kucharczyk.thomas.roles.PlayerCharacter;
import org.hibernate.Session;

import java.util.Date;

public class TableInteractionDemo {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {

            session.beginTransaction();

            // create test users
//            User user1 = new User("Tim", "Bob", "t.bob", "123", "tim@mail.de");
//        User user2 = new User("Susi", "Strolch", "sust", "123", "susi@mail.de");
//        User user3 = new User("Ben", "Aronovic", "druid", "123", "ben@mail.de");

            // create some characters
            Date currentTime = new Date();
            System.out.println("============ \n" + currentTime + "\n \n ==============");

//            User tempUser = session.get(User.class, 11);
//            PlayerCharacter tempPlayer = session.get(PlayerCharacter.class, 3);


//            User user3 = new User("Ben", "Aronovic", "druid", "123", "ben@mail.de");
            User user3 = session.get(User.class, 13);
            PlayerCharacter p3chara1 = new PlayerCharacter("Bardi3");
//            PlayerCharacter p3chara2 = new PlayerCharacter("Warrior2",  90, "orc", currentTime);
            user3.add(p3chara1);
//            user3.add(p3chara2);

//            tempUser.add(tempPlayer);
//            session.save(p3chara1);
//            session.save(p3chara2);
            session.save(user3);

//            System.out.println("hier sollte die liste kommen =============== \n \n");
//            System.out.println(tempUser.getNpcList());
//            System.out.println("hier sollte die liste enden =============== \n \n");
//            tempUser.toString();

//            Character tempChara = new Character("testChar", 10);

//            PlayerCharacter tempPlayerCharacter1 = new PlayerCharacter("timo");
//            System.out.println("======= START ==========");
//            tempPlayerCharacter1.toString();
//            System.out.println("======= END ==========");
//            session.save(tempPlayerCharacter1);

//            session.save(tempChara);
//            Npc tempNPC = new Npc("npc5");
//            System.out.println("======= START ==========");
//            tempNPC.toString();
//            System.out.println("======= END ==========");
//            tempUser.add(tempNPC);
//            session.save(tempNPC);

//            PlayerCharacter chara1 = new PlayerCharacter("timithy", currentTime);
//            PlayerCharacter chara1 = new PlayerCharacter("lonk", "elf", 42, currentTime, tempUser);
//            PlayerCharacter chara1 = new PlayerCharacter("lonk", 42);

//            System.out.println("Testing current user " + user1);
//            System.out.println("Testing temp chara " + chara1);

//            session.save(user1);
//            session.save(chara1);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            session.close();

        }

//        System.out.println("tut das?");
    }
}
