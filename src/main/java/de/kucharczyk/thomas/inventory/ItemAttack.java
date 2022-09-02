package de.kucharczyk.thomas.inventory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "item_attack")
public class ItemAttack extends Item {

    @Column(name = "damage_type")
    private String damageType;

    @Column(name = "dice_count")
    private int diceCount;

    @Column(name = "dice_sides")
    private int diceSides;

    @Column(name = "weapon_type")
    private String weaponType;

    @Column(name = "attack_range")
    private int attackRange;


    public ItemAttack() {
        super("name", "description", 0, ItemType.WEAPON);
    }

//    public ItemAttack(String damageType, int diceCount, int diceSides, String weaponType, int attackRange) {
    public ItemAttack(String name, String description, double weight) {
        super(name, description, weight, ItemType.WEAPON);
//        this.damageType = damageType;
//        this.diceCount = diceCount;
//        this.diceSides = diceSides;
//        this.weaponType = weaponType;
//        this.attackRange = attackRange;
    }

    public void addAttackProperties(String damageType, int diceCount, int diceSides, String weaponType, int attackRange) {
        this.damageType = damageType;
        this.diceCount = diceCount;
        this.diceSides = diceSides;
        this.weaponType = weaponType;
        this.attackRange = attackRange;
    }

    public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    public int getDiceCount() {
        return diceCount;
    }

    public void setDiceCount(int diceCount) {
        this.diceCount = diceCount;
    }

    public int getDiceSides() {
        return diceSides;
    }

    public void setDiceSides(int diceSides) {
        this.diceSides = diceSides;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }
}
