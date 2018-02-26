package de.data_models;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "DOG")
//@JsonIdentityReference(alwaysAsId = true)
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id", resolver = EntityIdResolver.class, scope = Dog.class)
public class Dog {

    @Id
    @Column(name = "DOG_ID", updatable=false, nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String passport_no;
    private String name;
    private String race;
    private String sex;
    @ManyToOne(cascade = CascadeType.MERGE)
    // @JsonBackReference
    @JoinColumn(name = "breeder_id")
    private Breeder breeder;
    private String chip_no;
    private String coat_colour;
    private Date date_of_birth;
    @ManyToOne(cascade = CascadeType.MERGE)
   // @JsonBackReference
    @JoinColumn(name = "owner_id")
    private Owner owner;


    public List<TournamentDog> getTournamentDogs() {
        return tournamentDogs;
    }

    public void setTournamentDogs(List<TournamentDog> tournamentDogs) {
        this.tournamentDogs = tournamentDogs;
    }

    public void addTournamentDog(TournamentDog tournamentDog) {
        boolean isAlreadyInList = false;
        for (int i = 0; i<this.tournamentDogs.size(); i++) {
            System.out.println("soweit");

            if (this.tournamentDogs.get(i).getTournament().getId() == tournamentDog.getTournament().getId()) {
                    System.out.println("Test"+ tournamentDog.getTournament().getId());
                    //this.tournamentDogs.set(i, tournamentDog);
                    this.tournamentDogs.get(i).setJudging(tournamentDog.getJudging());
                    isAlreadyInList = true;
                    break;
                }
        }
        if (!isAlreadyInList) {
            this.tournamentDogs.add(tournamentDog);
        }
    }


    @JsonIgnore
    @OneToMany(mappedBy = "dog", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TournamentDog> tournamentDogs = new ArrayList<>();



    /*public Set<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(Set<Tournament> tournaments) {
        this.tournaments = tournaments;
    }

    @ManyToMany(mappedBy = "participating_dogs", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Tournament> tournaments;*/

    public Dog(String passport_no, String name, String race, String sex, String chip_no,
               String coat_colour, Breeder breeder, Date date_of_birth, Owner owner) {
       // this.id = id;
        this.passport_no = passport_no;
        this.name = name;
        this.race = race;
        this.sex = sex;
        this.chip_no = chip_no;
        this.coat_colour = coat_colour;
        this.breeder = breeder;
        this.date_of_birth = date_of_birth;
        this.owner = owner;
    }

    public  Dog() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getPassport_no() {
        return passport_no;
    }

    public void setPassport_number(String passport_no) {
        this.passport_no = passport_no;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getChip_no() {
        return chip_no;
    }

    public void setChip_no(String chip_no) {
        this.chip_no = chip_no;
    }

    public String getCoat_colour() {
        return coat_colour;
    }

    public void setCoat_colour(String coat_colour) {
        this.coat_colour = coat_colour;
    }

    public Breeder getBreeder() {
        return breeder;
    }


    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }


    public Owner getOwner() {
        return owner;
    }

}

