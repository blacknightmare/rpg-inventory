package de.kucharczyk.thomas;

import de.kucharczyk.thomas.out.HibernateUtil;
import org.hibernate.Session;

public class FactoryPatternTester {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();


        try {
            session.beginTransaction();


//        CharacterFactory itemFactory = new CharacterFactory();
//
//        Bag tempBag = session.get(Bag.class, 2);

//        ItemMundane rope = new ItemMundane("Rope", "A rope made of hempen. 30ft long.", 2);
//
//        itemFactory.createCharacter("mundane","Rope", "A rope made of hempen. 30ft long.", 2);

//        tempBag.add(sword);
//        tempBag.add(rope);



        session.getTransaction().commit();
        System.out.println("Factory Pattern Tester");

        } finally {
            session.close();

        }

    }
}
