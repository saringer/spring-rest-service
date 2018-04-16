package de.data_models.data_transfer_objects;

public class CoursingResult {

    public CoursingResult() {

    }

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

    public String getTotalratings() {
        return totalratings;
    }

    public void setTotalratings(String totalratings) {
        this.totalratings = totalratings;
    }

    private Long maxNoRatings;

    private Long dog_id;
    private String dogname;
    private String ownername;
    private Long totalParticipations;
    private String totalratings;
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

    public Long getDog_id() {
        return dog_id;
    }

    public void setDog_id(Long dog_id) {
        this.dog_id = dog_id;
    }


}
