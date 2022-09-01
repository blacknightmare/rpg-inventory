package de.kucharczyk.thomas;

import de.kucharczyk.thomas.inventory.Bag;
import de.kucharczyk.thomas.inventory.Item;
import de.kucharczyk.thomas.inventory.ItemRarity;
import de.kucharczyk.thomas.inventory.ItemType;
import de.kucharczyk.thomas.roles.PlayerCharacter;
import org.hibernate.Session;

public class TestAddInventory {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();

//            User user3 = session.get(User.class, 13);
//            PlayerCharacter p3chara1 = new PlayerCharacter("LonkiLonk");
//            user3.add(p3chara1);
//            session.save(user3);


            // TEST 2
            PlayerCharacter tempChara = session.get(PlayerCharacter.class, 3);
//            System.out.println("======== " + tempChara.getName() + " ==================");
//
//            Bag backpack = new Bag("backpack2", 100);
//            tempChara.add(backpack);
//
//            session.save(tempChara);


//            Bag testBag = new Bag("testBag", 60);
//            session.save(testBag);

//            Bag testBag = session.get(Bag.class, 1);
//            System.out.println(testBag.getName());
//            testBag.setPlayerCharacter(tempChara);
//            session.save(testBag);

            // TEST 4
//            User tempUser = session.get(User.class, 13);
//            System.out.println("start for each USER!!!!!");
//            for (PlayerCharacter tempPlayer : tempUser.getCharacters()) {
//                System.out.println("name: " + tempPlayer.getName() + " \n");
//
//            }
//            System.out.println("end for each USER!!!!!");

//            PlayerCharacter tempChara = session.get(PlayerCharacter.class, 3);
//            System.out.println("start for each!!!!!");
//            for (Bag tempBag : tempChara.getBagList()
//                 ) {
//                System.out.println(tempBag.getBagId() + " - " + tempBag.getName());
//
//            }

            // Test 5 adding items
//            Bag tempBag = session.get(Bag.class, 2);
//            System.out.println("ID: "+ tempBag.getPlayerCharacter().getCharacterId() + " - Name: " + tempBag.getPlayerCharacter().getName());
//
//            System.out.println("Lonk wishes to add a boot, a stone, a magic sword to his backpack!");
//
//            Item boot = new Item("woodboot", "simple boot of wood", 4.15, ItemType.MUNDANE, ItemRarity.COMMON);
//            Item stone = new Item("Stone", "can be thrown", 1.44, ItemType.MISCELLANEOUS, ItemRarity.COMMON);
//            Item magicSword = new Item("magical Sword", "a sword that glows in the dark", 6.79, ItemType.WEAPON, ItemRarity.UNCOMMON);
//
//            tempBag.add(boot);
//            tempBag.add(stone);
//            tempBag.add(magicSword);
//            tempBag.add(boot);

            Item tempStone = session.get(Item.class, 2);
            tempStone.setType(ItemType.MUNDANE);

            session.save(tempStone);



            session.getTransaction().commit();

            System.out.println("Bag Saved!");



        } finally {
            session.close();

        }
    }
}
