package de.kucharczyk.thomas;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username")
    @NotNull
    private String username;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "email")
    @NotNull
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PlayerCharacter> playerCharacters = new ArrayList<PlayerCharacter>();

    @OneToMany(mappedBy = "user",cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    private List<Npc> npcList;


    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(String firstName, String lastName, String username, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User() {
        super();
    }

    public List<PlayerCharacter> getCharacters() {
        return playerCharacters;
    }

    public void setCharacters(List<PlayerCharacter> playerCharacters) {
        this.playerCharacters = playerCharacters;
    }

    @Override
    public String toString() {
        return "user{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Npc> getNpcList() {
        return npcList;
    }

    public void setNpcList(List<Npc> npcList) {
        this.npcList = npcList;
    }

    public void add(Npc tempNpc) {

        if (npcList == null) {
            npcList = new ArrayList<>();
        }

        npcList.add(tempNpc);

        tempNpc.setUser(this);
    }
    public void add(PlayerCharacter tempPChara) {

        if (playerCharacters == null) {
            playerCharacters = new ArrayList<>();
        }

        playerCharacters.add(tempPChara);

        tempPChara.setUser(this);
    }
}
