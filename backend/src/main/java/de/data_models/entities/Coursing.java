package de.data_models.entities;

import de.data_models.data_access_objects.coursing.CoursingDetail;
import de.data_models.data_access_objects.coursing.Rating;
import de.data_models.data_access_objects.coursing.TotalParticipation;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

// Composite Key
@Entity
@Table(name = "coursing")
@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "totalparticipationcoursing",
                classes = {
                        @ConstructorResult(
                                targetClass = TotalParticipation.class,
                                columns = {
                                        @ColumnResult(name = "dog_id", type = Long.class),
                                        @ColumnResult(name = "name", type = String.class),
                                        @ColumnResult(name = "total_participation", type = Long.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "ratings",
                classes = {
                        @ConstructorResult(
                                targetClass = Rating.class,
                                columns = {
                                        @ColumnResult(name = "coursing_rating", type = Double.class),
                                        @ColumnResult(name = "double_weighted", type = Boolean.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "coursingdetails",
                classes = {
                        @ConstructorResult(
                                targetClass = CoursingDetail.class,
                                columns = {
                                        @ColumnResult(name = "title", type = String.class),
                                        @ColumnResult(name = "coursing_rating", type = Double.class),
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

public class Coursing implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "dog_id")
    private Dog dog;


    @Id
    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;


    private Double coursingRating;
    private int coursingPlacement;
    private String coursingClass;
    private String dogname;
    private boolean notfinished;
    private boolean notstarted;
    private boolean withdrawn;
    private boolean injured;
    private boolean disqualified;


    public String getCoursingClass() {
        return coursingClass;
    }

    public void setCoursingClass(String coursingClass) {
        this.coursingClass = coursingClass;
    }


    public Double getCoursingRating() {
        return coursingRating;
    }

    public void setCoursingRating(Double coursingRating) {
        this.coursingRating = coursingRating;
    }

    public int getCoursingPlacement() {
        return coursingPlacement;
    }

    public void setCoursingPlacement(int coursingPlacement) {
        this.coursingPlacement = coursingPlacement;
    }


    public String getDogname() {
        return dogname;
    }

    public void setDogname(String dogname) {
        this.dogname = dogname;
    }

    public boolean isNotfinished() {
        return notfinished;
    }

    public void setNotfinished(boolean notfinished) {
        this.notfinished = notfinished;
    }

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

        Coursing that = (Coursing) o;
        return Objects.equals(dog, that.dog) &&
                Objects.equals(tournament, that.tournament);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dog, tournament);
    }


}
