package de.kucharczyk.thomas.roles;

import com.sun.istack.NotNull;
import de.kucharczyk.thomas.NameConverter;
import de.kucharczyk.thomas.User;
import de.kucharczyk.thomas.inventory.Bag;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Builder
@Entity
@Table(name = "player_character")
public class PlayerCharacter {

    @Id
    @Column(name = "character_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int characterId;

    @NotNull
    private String name;

    @ColumnDefault("'human'")
    private String race = "human";

    @Column(name = "carry_weight")
    @ColumnDefault("10")
    private int carryWeight = 10;

    @Column(name = "flag_dead")
    private int flagDead = 0;

    @Column(name = "flag_active")
    private int flagActive = 1;

    @Column(name = "datetime_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetimeAdd = new Date();

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="user_id")
    public User user;

    @OneToMany(mappedBy = "playerCharacter",cascade= {CascadeType.ALL})
    private List<Bag> bagList;


    public PlayerCharacter() {
    }

    public PlayerCharacter(String name) {
        this.name = name;
    }


    public PlayerCharacter(String name, int carryWeight, String race) {
        this.name = name;
        this.race = race;
        this.carryWeight = carryWeight;
    }

    public int getCharacterId() {
        return characterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getCarryWeight() {
        return carryWeight;
    }

    public void setCarryWeight(int carryWeight) {
        this.carryWeight = carryWeight;
    }

    public Date getDatetimeAdd() {
        return datetimeAdd;
    }

    public void setDatetimeAdd(Date datetimeAdd) {
        this.datetimeAdd = datetimeAdd;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Bag> getBagList() {
        return bagList;
    }

    public void setBagList(List<Bag> bagList) {
        this.bagList = bagList;
    }

    public void add(Bag tempBag) {

        if (bagList == null) {
            bagList = new ArrayList<>();
        }

        bagList.add(tempBag);

        System.out.println("!!!!!!!!!!!!!!!!!\n\n"
        + tempBag.getName() + " \n\n !!!!!!!!!!!!!!!!!");

        tempBag.setPlayerCharacter(this);
    }

    public Bag findBagById(int id) {
        for (Bag tempBag : bagList) {
            if(tempBag.getBagId() == id) {
                return tempBag;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Character{" +
                "characterId=" + characterId +
                ", name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", carryWeight=" + carryWeight +
                ", datetimeAdd=" + datetimeAdd +
                ", user=" + user +
                '}';
    }


}
