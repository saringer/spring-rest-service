package de.data_models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

// Composite Key
@Entity
@Table(name = "tournament_dog")
public class TournamentDog implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "dog_id")
    private Dog dog;


    @Id
    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;


    public int getJudging() {
        return judging;
    }

    public void setJudging(int judging) {
        this.judging = judging;
    }

    private int judging;


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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        TournamentDog that = (TournamentDog) o;
        return Objects.equals(dog, that.dog) &&
                Objects.equals(tournament, that.tournament);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dog, tournament);
    }


}
