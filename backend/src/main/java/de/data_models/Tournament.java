package de.data_models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.*;

@Entity
@Table(name = "TOURNAMENT")
//@JsonIdentityReference(alwaysAsId = true)
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id", resolver = EntityIdResolver.class, scope = Tournament.class)
public class Tournament {


    public List<TournamentDog> getTournamentDogs() {
        return tournamentDogs;
    }

    public void setTournamentDogs(List<TournamentDog> tournamentDogs) {
        this.tournamentDogs = tournamentDogs;
    }


    @OneToMany(mappedBy = "tournament")
    private List<TournamentDog> tournamentDogs = new ArrayList<>();


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
    @Column(name = "TOURNAMENT_ID", updatable = false, nullable = false)
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

    /*@ManyToMany(fetch = FetchType.LAZY)
    //@JsonManagedReference
    private Set<Dog> participating_dogs;


    public Set<Dog> getParticipating_dogs() {
        return participating_dogs;
    }

    public void setParticipating_dogs(Set<Dog> participating_dogs) {
        this.participating_dogs = participating_dogs;
    }*/

    public Set<Judge> getParticipating_judges() {
        return participating_judges;
    }

    public void setParticipating_judges(Set<Judge> participating_judges) {
        this.participating_judges = participating_judges;
    }


    @ManyToMany(fetch = FetchType.LAZY)
    //@JsonManagedReference
    private Set<Judge> participating_judges;




}
