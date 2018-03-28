package de.data_transfer_objects;

import de.data_models.Dog;
import de.data_models.Tournament;

public class RaceDTO {

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

    public Long getTournamentid() {
        return tournamentid;
    }

    public void setTournamentid(Long tournamentid) {
        this.tournamentid = tournamentid;
    }

    public String getDogname() {
        return dogname;
    }

    public void setDogname(String dogname) {
        this.dogname = dogname;
    }

    private String raceTime;
    private Long racePlacement;
    private boolean withdrawn;
    private boolean notfinished;
    private Long tournamentid;
    private String dogname;

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    private Tournament tournament;
    private Dog dog;
    private String distance;
}
