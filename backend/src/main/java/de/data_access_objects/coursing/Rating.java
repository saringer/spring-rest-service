package de.data_access_objects.coursing;

public class Rating {

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

    private Double coursing_rating;
    private boolean double_weighted;
    public Rating(Double coursing_rating, boolean double_weighted) {
            this.coursing_rating = coursing_rating;
            this. double_weighted = double_weighted;
    }
}
