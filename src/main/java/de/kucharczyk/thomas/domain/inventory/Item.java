package de.kucharczyk.thomas.domain.inventory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
//@Entity
//@Table(name = "item")
public abstract class Item implements Serializable {
//public abstract class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", unique = true, nullable = false, updatable = false, columnDefinition = "uniqueidentifier")
    private int itemId;

    private String name;

    private String description;

    private double weight;

    @Column(name = "gold_value")
    private double goldValue;

    @Enumerated(EnumType.STRING)
    private ItemType type;

    @Enumerated(EnumType.STRING)
    private ItemRarity rarity;

    private String comment;

    @Column(name = "flag_active")
    private int flagActive = 1;

    @Column(name = "timestamp_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestampUpdate = new Date();

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "bag_id")
    private Bag bag;


//    public Item() {
//    }


    public Item(String name, String description, double weight, ItemType type) {
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public ItemRarity getRarity() {
        return rarity;
    }

    public void setRarity(ItemRarity rarity) {
        this.rarity = rarity;
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

    public double getGoldValue() {
        return goldValue;
    }

    public void setGoldValue(double goldValue) {
        this.goldValue = goldValue;
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

    @PrePersist
    public void setUpdateTimestamp() {
        timestampUpdate = new Date();
    }

}
