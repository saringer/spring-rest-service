package de.data_models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DOG")
public class Dog {

    @Id
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
    private Integer chip_no;
    private String coat_colour;
    private Date date_of_birth;
    @ManyToOne(cascade = CascadeType.MERGE)
   // @JsonBackReference
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Dog(String passport_no, String name, String race, String sex, Integer chip_no,
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

    public Integer getChip_no() {
        return chip_no;
    }

    public void setChip_no(Integer chip_no) {
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
