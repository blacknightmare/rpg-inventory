package de.kucharczyk.thomas;

import de.kucharczyk.thomas.coursestuff.Course;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bag")
public class Bag {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "bag_id")
    private int bagId;

    @Column(name = "name")
    private String name;

    private float size;

    @Column(name = "flag_active")
    private int flagActive;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "character_id")
    private PlayerCharacter playerCharacter;

    @OneToMany(mappedBy = "bag",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Item> itemList;

    public Bag() {
    }

    public Bag(String name) {
        this.name = name;
    }

    public Bag(String name, float size, int flagActive) {
        this.name = name;
        this.size = size;
        this.flagActive = flagActive;
    }

    public int getBagId() {
        return bagId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public int getFlagActive() {
        return flagActive;
    }

    public void setFlagActive(int flagActive) {
        this.flagActive = flagActive;
    }

    public PlayerCharacter getPlayerCharacter() {
        return playerCharacter;
    }

    public void setPlayerCharacter(PlayerCharacter playerCharacter) {
        this.playerCharacter = playerCharacter;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public void add(Item tempItem) {

        if (itemList == null) {
            itemList = new ArrayList<>();
        }

        itemList.add(tempItem);

        tempItem.setBag(this);
    }

    @Override
    public String toString() {
        return "Bag{" +
                "bagId=" + bagId +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", flagActive=" + flagActive +
                ", playerCharacter=" + playerCharacter +
                '}';
    }
}
