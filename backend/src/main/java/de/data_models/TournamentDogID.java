package de.data_models;

import java.io.Serializable;

public class TournamentDogID implements Serializable {

    private  Dog dog;

    private Tournament tournament;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dog == null) ? 0 : dog.hashCode());
        result = prime * result + ((tournament == null) ? 0 : tournament.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TournamentDogID other = (TournamentDogID) obj;
        if (dog == null) {
            if (other.dog != null)
                return false;
        } else if (!dog.equals(other.dog))
            return false;
        if (tournament == null) {
            if (other.tournament != null)
                return false;
        } else if (!tournament.equals(other.tournament))
            return false;
        return true;
    }

}
