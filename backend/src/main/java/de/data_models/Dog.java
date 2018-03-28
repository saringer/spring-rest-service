package de.data_models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "DOG")
//@JsonIdentityReference(alwaysAsId = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", resolver = EntityIdResolver.class, scope = Dog.class)
public class Dog {

    @Id
    @Column(name = "DOG_ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String passport_no;
    @NotNull
    private String name;
    @NotNull
    private String race;
    @NotNull
    private String sex;
    @ManyToOne
    @JoinColumn(name = "breeder_id")
    private Breeder breeder;
    private String chip_no;
    private String coat_colour;
    private Date date_of_birth;
    @ManyToOne
    // @JsonBackReference
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @JsonIgnore
    @OneToMany(mappedBy = "dog", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Coursing> coursings = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "dog", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Race> races = new ArrayList<>();

    public List<Race> getRaces() {
        return races;
    }

    public void setRaces(List<Race> races) {
        this.races = races;
    }

    public List<Coursing> getCoursings() {
        return coursings;
    }

    public void setCoursings(List<Coursing> coursings) {
        this.coursings = coursings;
    }

    public void addCoursing(Coursing coursing) {
        boolean isAlreadyInList = false;
        for (int i = 0; i < this.coursings.size(); i++) {

            if (this.coursings.get(i).getTournament().getId() == coursing.getTournament().getId()) {
                //this.coursings.set(i, coursing);
                this.coursings.get(i).setCoursingRating(coursing.getCoursingRating());
                this.coursings.get(i).setCoursingPlacement(coursing.getCoursingPlacement());
                this.coursings.get(i).setCoursingClass(coursing.getCoursingClass());
                this.coursings.get(i).setDogname(coursing.getDogname());


                isAlreadyInList = true;
                break;
            }
        }
        if (!isAlreadyInList) {
            this.coursings.add(coursing);
        }
    }

    public void addRace(Race race) {
        boolean isAlreadyInList = false;
        for (int i = 0; i < this.races.size(); i++) {
            if (this.races.get(i).getTournament().getId() == race.getTournament().getId()) {
                //this.coursings.set(i, coursing);
                this.races.get(i).setRaceTime(race.getRaceTime());
                this.races.get(i).setRacePlacement(race.getRacePlacement());
                this.races.get(i).setWithdrawn(race.isWithdrawn());
                this.races.get(i).setNotfinished(race.isNotfinished());
                this.races.get(i).setRaceClass(race.getRaceClass());

                isAlreadyInList = true;
                break;
            }
        }
        if (!isAlreadyInList) {
            this.races.add(race);
        }
    }

    public void deleteCoursing(Long tournament_id) {
        for (int i = 0; i < this.coursings.size(); i++) {

            if (this.coursings.get(i).getTournament().getId() == tournament_id) {
                this.coursings.remove(i);
                break;
            }
        }
    }

    public void deleteRace(Long tournament_id) {
        for (int i = 0; i < this.races.size(); i++) {

            if (this.races.get(i).getTournament().getId() == tournament_id) {
                this.races.remove(i);
                break;
            }
        }
    }


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

    public Dog() {

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

    public void setBreeder(Breeder breeder) {
        this.breeder = breeder;
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

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

}

