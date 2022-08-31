package de.kucharczyk.thomas;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int itemId;

    private String name;

    private String description;

    private float weight;

    private int type;

    private String comment;

    @Column(name = "flag_active")
    private int flagActive;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "bag_id")
    private Bag bag;

    public Item() {
    }

    public Item(String name, String description, float weight, int type) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.type = type;
    }

    public int getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getFlagActive() {
        return flagActive;
    }

    public void setFlagActive(int flagActive) {
        this.flagActive = flagActive;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                ", type=" + type +
                ", comment='" + comment + '\'' +
                ", flagActive=" + flagActive +
                ", bag=" + bag +
                '}';
    }
}
