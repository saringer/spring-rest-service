package de.data_models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CLUB")
public class Club {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClubname() {
        return clubname;
    }

    public void setClubname(String clubname) {
        this.clubname = clubname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String clubname;
    public String street;
    public String postalcode;
    public String city;
    public String country;

    public Set<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(Set<Tournament> tournaments) {
        this.tournaments = tournaments;
    }

    @JsonBackReference
    @OneToMany(mappedBy = "club", cascade = CascadeType.MERGE)
    private Set<Tournament> tournaments;
}