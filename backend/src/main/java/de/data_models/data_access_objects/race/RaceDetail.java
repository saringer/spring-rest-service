package de.data_models.data_access_objects.race;

public class RaceDetail {

    public RaceDetail(String title, Integer points, boolean double_weighted, boolean notstarted,
                          boolean notfinished, boolean injured, boolean withdrawn, boolean disqualified) {
        this.title = title;
        this.points = points;
        this.double_weighted = double_weighted;
        this.notstarted = notstarted;
        this.notfinished = notfinished;
        this.injured = injured;
        this.withdrawn = withdrawn;
        this.disqualified = disqualified;

    }


    private String title;
    private Integer points;
    private boolean double_weighted;
    private boolean notstarted;
    private boolean notfinished;
    private boolean injured;
    private boolean withdrawn;
    private boolean disqualified;


    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
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
