package de.data_transfer_objects;

public class CoursingResult {

    public String getDogname() {
        return dogname;
    }

    public void setDogname(String dogname) {
        this.dogname = dogname;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public Long getTotalParticipations() {
        return totalParticipations;
    }

    public void setTotalParticipations(Long totalParticipations) {
        this.totalParticipations = totalParticipations;
    }

    public Long getTotalratings() {
        return totalratings;
    }

    public void setTotalratings(Long totalratings) {
        this.totalratings = totalratings;
    }

    Long maxNoRatings;
    private String dogname;
    private String ownername;
    private Long totalParticipations;
    private Long totalratings;
    private Long ranking;

    public Long getRanking() {
        return ranking;
    }

    public void setRanking(Long ranking) {
        this.ranking = ranking;
    }

    public Long getMaxNoRatings() {
        return maxNoRatings;
    }

    public void setMaxNoRatings(Long maxNoRatings) {
        this.maxNoRatings = maxNoRatings;
    }


}
