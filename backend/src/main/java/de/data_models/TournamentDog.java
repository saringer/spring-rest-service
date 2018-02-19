package de.data_models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(TournamentDogID.class)
@Table(name = "tournament_dog")
public class TournamentDog implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "dog_id")
    private Dog dog;

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

    @Id
    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;


}
