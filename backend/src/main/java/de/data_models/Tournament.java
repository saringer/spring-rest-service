package de.data_models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TOURNAMENT")
public class Tournament {

    public Tournament() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTournamenttype() {
        return tournamenttype;
    }

    public void setTournamenttype(String tournamenttype) {
        this.tournamenttype = tournamenttype;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String title;
    public String tournamenttype;


    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    // @JsonBackReference
    @JoinColumn(name = "club_id")
    private Club club;
    public Date date;
}
