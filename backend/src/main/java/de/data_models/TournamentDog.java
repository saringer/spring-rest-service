package de.data_models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

// Composite Key
@Entity
@Table(name = "tournament_dog_coursing")
public class TournamentDog implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "dog_id")
    private Dog dog;


    @Id
    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;


    public int getCoursingrating1() {
        return coursingrating1;
    }

    public void setCoursingrating1(int coursingrating1) {
        this.coursingrating1 = coursingrating1;
    }


    public int getCoursingrating2() {
        return coursingrating2;
    }

    public void setCoursingrating2(int coursingrating2) {
        this.coursingrating2 = coursingrating2;
    }

    public int getCoursingrating3() {
        return coursingrating3;
    }

    public void setCoursingrating3(int coursingrating3) {
        this.coursingrating3 = coursingrating3;
    }

    public int getCoursingrating4() {
        return coursingrating4;
    }

    public void setCoursingrating4(int coursingrating4) {
        this.coursingrating4 = coursingrating4;
    }

    public int getCoursingrating5() {
        return coursingrating5;
    }

    public void setCoursingrating5(int coursingrating5) {
        this.coursingrating5 = coursingrating5;
    }

    public int getCoursingrating6() {
        return coursingrating6;
    }

    public void setCoursingrating6(int coursingrating6) {
        this.coursingrating6 = coursingrating6;
    }

    public int getCoursingrating7() {
        return coursingrating7;
    }

    public void setCoursingrating7(int coursingrating7) {
        this.coursingrating7 = coursingrating7;
    }

    public int getCoursingrating8() {
        return coursingrating8;
    }

    public void setCoursingrating8(int coursingrating8) {
        this.coursingrating8 = coursingrating8;
    }

    public int getCoursingrating9() {
        return coursingrating9;
    }

    public void setCoursingrating9(int coursingrating9) {
        this.coursingrating9 = coursingrating9;
    }

    public int getCoursingrating10() {
        return coursingrating10;
    }

    public void setCoursingrating10(int coursingrating10) {
        this.coursingrating10 = coursingrating10;
    }

    public int getCoursingrating11() {
        return coursingrating11;
    }

    public void setCoursingrating11(int coursingrating11) {
        this.coursingrating11 = coursingrating11;
    }

    public int getCoursingrating12() {
        return coursingrating12;
    }

    public void setCoursingrating12(int coursingrating12) {
        this.coursingrating12 = coursingrating12;
    }

    private int coursingrating1;
    private int coursingrating2;
    private int coursingrating3;
    private int coursingrating4;
    private int coursingrating5;
    private int coursingrating6;
    private int coursingrating7;
    private int coursingrating8;
    private int coursingrating9;
    private int coursingrating10;
    private int coursingrating11;
    private int coursingrating12;


    public String getDogname() {
        return dogname;
    }

    public void setDogname(String dogname) {
        this.dogname = dogname;
    }

    public String getTournamenttype() {
        return tournamenttype;
    }

    public void setTournamenttype(String tournamenttype) {
        this.tournamenttype = tournamenttype;
    }

    private String dogname;
    private String tournamenttype;


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
