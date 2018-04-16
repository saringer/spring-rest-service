package de.data_models.data_access_objects.coursing;

public class CoursingDetail {

    public CoursingDetail(String title, Double coursing_rating, boolean double_weighted, boolean notstarted,
                          boolean notfinished, boolean injured, boolean withdrawn, boolean disqualified) {
        this.title = title;
        this.coursing_rating = coursing_rating;
        this.double_weighted = double_weighted;
        this.notstarted = notstarted;
        this.notfinished = notfinished;
        this.injured = injured;
        this.withdrawn = withdrawn;
        this.disqualified = disqualified;

    }


    private String title;
    private Double coursing_rating;
    private boolean double_weighted;
    private boolean notstarted;
    private boolean notfinished;
    private boolean injured;
    private boolean withdrawn;
    private boolean disqualified;


    public Double getCoursing_rating() {
        return coursing_rating;
    }

    public void setCoursing_rating(Double coursing_rating) {
        this.coursing_rating = coursing_rating;
    }

    public boolean isDouble_weighted() {
        return double_weighted;
    }

    public void setDouble_weighted(boolean double_weighted) {
        this.double_weighted = double_weighted;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isNotstarted() {
        return notstarted;
    }

    public void setNotstarted(boolean notstarted) {
        this.notstarted = notstarted;
    }

    public boolean isNotfinished() {
        return notfinished;
    }

    public void setNotfinished(boolean notfinished) {
        this.notfinished = notfinished;
    }

    public boolean isWithdrawn() {
        return withdrawn;
    }

    public void setWithdrawn(boolean withdrawn) {
        this.withdrawn = withdrawn;
    }

    public boolean isDisqualified() {
        return disqualified;
    }

    public void setDisqualified(boolean disqualified) {
        this.disqualified = disqualified;
    }

    public boolean isInjured() {
        return injured;
    }

    public void setInjured(boolean injured) {
        this.injured = injured;
    }

}
