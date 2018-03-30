package de.data_transfer_objects;

import de.data_models.Dog;
import de.data_models.Tournament;

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
    private Long tournamentid;
    private String dogname;

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
