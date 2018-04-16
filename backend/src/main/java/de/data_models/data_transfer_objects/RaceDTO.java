package de.data_models.data_transfer_objects;

import de.data_models.entities.Dog;
import de.data_models.entities.Tournament;

public class RaceDTO {

    public Double getRaceTime() {
        return raceTime;
    }

    public void setRaceTime(Double raceTime) {
        this.raceTime = raceTime;
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

    private Double raceTime;

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    private Integer points;
    private boolean notfinished;
    private boolean notstarted;
    private boolean withdrawn;
    private boolean injured;
    private boolean disqualified;
    private Long tournamentid;
    private String dogname;

    public boolean isNotstarted() {
        return notstarted;
    }

    public void setNotstarted(boolean notstarted) {
        this.notstarted = notstarted;
    }

    public boolean isWithdrawn() {
        return withdrawn;
    }

    public void setWithdrawn(boolean withdrawn) {
        this.withdrawn = withdrawn;
    }

    public boolean isInjured() {
        return injured;
    }

    public void setInjured(boolean injured) {
        this.injured = injured;
    }

    public boolean isDisqualified() {
        return disqualified;
    }

    public void setDisqualified(boolean disqualified) {
        this.disqualified = disqualified;
    }

    public String getRaceClass() {
        return raceClass;
    }

    public void setRaceClass(String raceClass) {
        this.raceClass = raceClass;
    }

    private String raceClass;

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
