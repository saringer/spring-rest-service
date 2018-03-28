package de.data_models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "race")
public class Race implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "dog_id")
    private Dog dog;


    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public String getRaceClass() {
        return raceClass;
    }

    public void setRaceClass(String raceClass) {
        this.raceClass = raceClass;
    }

    public String getDogname() {
        return dogname;
    }

    public void setDogname(String dogname) {
        this.dogname = dogname;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;


    private String raceClass;
    private String dogname;

    public String getRaceTime() {
        return raceTime;
    }

    public void setRaceTime(String raceTime) {
        this.raceTime = raceTime;
    }

    public Long getRacePlacement() {
        return racePlacement;
    }

    public void setRacePlacement(Long racePlacement) {
        this.racePlacement = racePlacement;
    }

    public boolean isWithdrawn() {
        return withdrawn;
    }

    public void setWithdrawn(boolean withdrawn) {
        this.withdrawn = withdrawn;
    }

    public boolean isNotfinished() {
        return notfinished;
    }

    public void setNotfinished(boolean notfinished) {
        this.notfinished = notfinished;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }


    private String raceTime;
   private Long racePlacement;
   private boolean withdrawn;
   private boolean notfinished;
   private String distance;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Race that = (Race) o;
        return Objects.equals(dog, that.dog) &&
                Objects.equals(tournament, that.tournament);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dog, tournament);
    }

}
