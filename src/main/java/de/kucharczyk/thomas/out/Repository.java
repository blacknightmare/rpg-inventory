package de.kucharczyk.thomas.out;

import de.kucharczyk.thomas.User;
import de.kucharczyk.thomas.domain.inventory.Bag;
import de.kucharczyk.thomas.domain.inventory.ItemMundane;
import de.kucharczyk.thomas.domain.roles.Npc;
import de.kucharczyk.thomas.domain.roles.PlayerCharacter;
import org.hibernate.Session;

public class Repository {
    /*
    TODOS: session
    save
    delete

    TODOS: obj
    add
    remove

 */

    private Session session;

//    private int userId;

//    private User user;


    public void save(Object obj) {


        session.beginTransaction();

        session.save(obj);

//        System.out.println("\nObject saved " + obj.getClass());

        session.getTransaction().commit();

    }

    public void delete(Object obj) {
        session.beginTransaction();

        session.delete(obj);

//        System.out.println("\nObject removed " + obj.getClass());

        session.getTransaction().commit();
    }



//    public Object findById(Class givenClass, int id) {
//        if(id > -1) {
//            Object obj = session.get(givenClass, id);
//            return obj;
//        } else {
//            System.out.println("Must be a positive number.");
//            throw new IllegalArgumentException("must be positive");
//        }
//    }

    public User getUserById(int id) {
        User foundObj = session.get(User.class, id);
        return foundObj;
    }

    public PlayerCharacter getPCById(int id) {
        PlayerCharacter foundObj = session.get(PlayerCharacter.class, id);
        return foundObj;
    }

    public Bag getBagById(int id) {
        Bag foundObj = session.get(Bag.class, id);
        return foundObj;
    }

    public ItemMundane getItemMundaneById(int id) {
        ItemMundane foundObj = session.get(ItemMundane.class, id);
        return foundObj;
    }
    public void open() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    public void close(){
        session.close();
    }

//    public void setUserById(int userId) {
//        if(userId > -1) {
//            this.userId = userId;
//            user = session.get(User.class, userId);
//        } else {
//            System.out.println("Must be a positive number.");
//        }
//    }

    public void methodTester() {
//        System.out.println("Start method Tester");
//        setUserById(14);
//        User currentUser = getUser();
//        if(currentUser != null){
//            System.out.println("Username: " + currentUser.getUsername());
//
//            Npc newNpc = new Npc("RepoTester");
//            currentUser.add(newNpc);
//            save(currentUser);
//            System.out.println("did it save?");
//        }
//
//        System.out.println("End Method Tester");
//        session.close();
    }


}
