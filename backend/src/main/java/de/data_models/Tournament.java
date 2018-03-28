package de.data_models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "TOURNAMENT")
//@JsonIdentityReference(alwaysAsId = true)
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id", resolver = EntityIdResolver.class, scope = Tournament.class)
public class Tournament {


    public List<Coursing> getCoursings() {
        return coursings;
    }

    public void setCoursings(List<Coursing> coursings) {
        this.coursings = coursings;
    }


    @OneToMany(mappedBy = "tournament")
    private List<Coursing> coursings = new ArrayList<>();

    public List<Race> getRaces() {
        return races;
    }

    public void setRaces(List<Race> races) {
        this.races = races;
    }

    @OneToMany(mappedBy = "tournament")
    private List<Race> races = new ArrayList<>();

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
    @Column(name = "TOURNAMENT_ID", updatable = false, nullable = false)
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


    //@ManyToOne
    //@JoinColumn
    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    private Date date;

    public boolean isDouble_weighted() {
        return double_weighted;
    }

    public void setDouble_weighted(boolean double_weighted) {
        this.double_weighted = double_weighted;
    }

    private boolean double_weighted;



    public List<Judge> getParticipating_judges() {
        return participating_judges;
    }

    public void setParticipating_judges(List<Judge> participating_judges) {
        this.participating_judges = participating_judges;
    }

    public void removeJudge(long judge_id) {
        for (int i=0;i<participating_judges.size();i++) {
            if (participating_judges.get(i).getId() == judge_id) {
                participating_judges.remove(i);
                break;
            }
        }
    }


    @ManyToMany(fetch = FetchType.LAZY)
    //@JsonManagedReference
    private List<Judge> participating_judges;




}
