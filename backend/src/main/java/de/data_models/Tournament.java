package de.data_models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TOURNAMENT")
public class Tournament {

    public Tournament() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTournamenttype() {
        return tournamenttype;
    }

    public void setTournamenttype(String tournamenttype) {
        this.tournamenttype = tournamenttype;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String title;
    public String tournamenttype;


    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }



    @ManyToOne
    @JoinColumn
    private Club club;

    public Date date;

    public Set<Dog> getParticipating_dogs() {
        return participating_dogs;
    }

    public void setParticipating_dogs(Set<Dog> participating_dogs) {
        this.participating_dogs = participating_dogs;
    }

    public Set<Judge> getParticipating_judges() {
        return participating_judges;
    }

    public void setParticipating_judges(Set<Judge> participating_judges) {
        this.participating_judges = participating_judges;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    //@JsonManagedReference
    private Set<Dog> participating_dogs;

    @ManyToMany(fetch = FetchType.LAZY)
    //@JsonManagedReference
    private Set<Judge> participating_judges;

}
