package de.data_models.entities;

import de.data_models.data_access_objects.coursing.CoursingDetail;
import de.data_models.data_access_objects.coursing.Rating;
import de.data_models.data_access_objects.coursing.TotalParticipationCoursing;
import de.data_models.data_access_objects.race.RaceDetail;
import de.data_models.data_access_objects.race.RaceRating;
import de.data_models.data_access_objects.race.TotalParticipationRace;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "race")
@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "totalparticipationrace",
                classes = {
                        @ConstructorResult(
                                targetClass = TotalParticipationRace.class,
                                columns = {
                                        @ColumnResult(name = "dog_id", type = Long.class),
                                        @ColumnResult(name = "name", type = String.class),
                                        @ColumnResult(name = "total_participation", type = Long.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "raceratings",
                classes = {
                        @ConstructorResult(
                                targetClass = RaceRating.class,
                                columns = {
                                        @ColumnResult(name = "points", type = Integer.class),
                                        @ColumnResult(name = "double_weighted", type = Boolean.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "racedetails",
                classes = {
                        @ConstructorResult(
                                targetClass = RaceDetail.class,
                                columns = {
                                        @ColumnResult(name = "title", type = String.class),
                                        @ColumnResult(name = "points", type = Integer.class),
                                        @ColumnResult(name = "double_weighted", type = Boolean.class),
                                        @ColumnResult(name = "notstarted", type = Boolean.class),
                                        @ColumnResult(name = "notfinished", type = Boolean.class),
                                        @ColumnResult(name = "injured", type = Boolean.class),
                                        @ColumnResult(name = "withdrawn", type = Boolean.class),
                                        @ColumnResult(name = "disqualified", type = Boolean.class)
                                }
                        )
                }
        )
})
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


    private Double raceTime;
    private boolean notfinished;
    private boolean notstarted;
    private boolean withdrawn;
    private boolean injured;
    private boolean disqualified;
    private String distance;

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


    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    private Integer points;

    public Double getRaceTime() {
        return raceTime;
    }

    public void setRaceTime(Double raceTime) {
        this.raceTime = raceTime;
    }


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
