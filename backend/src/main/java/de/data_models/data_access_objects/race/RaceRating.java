package de.data_models.data_access_objects.race;

public class RaceRating {

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

    private Integer points;
    private boolean double_weighted;
    public RaceRating(Integer points, boolean double_weighted) {
        this.points = points;
        this. double_weighted = double_weighted;
    }
}
