package de.data_models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

public class TournamentDogPK implements Serializable {


    public Long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
    }

    public Long getDogId() {
        return dogId;
    }

    public void setDogId(Long dogId) {
        this.dogId = dogId;
    }

    @Column(name = "dog_id")
    private Long dogId;

    @Column(name = "tournament_id")
    private Long tournamentId;

    private TournamentDogPK() {}

    public TournamentDogPK(
            Long dogId,
            Long tournamentId) {
        this.dogId = dogId;
        this.tournamentId = tournamentId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        TournamentDogPK that = (TournamentDogPK) o;
        return Objects.equals(dogId, that.dogId) &&
                Objects.equals(tournamentId, that.tournamentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dogId, tournamentId);
    }
}
