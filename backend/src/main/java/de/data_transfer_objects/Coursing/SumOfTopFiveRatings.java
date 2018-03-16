package de.data_transfer_objects.Coursing;

public class SumOfTopFiveRatings {

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    private Long sum;

    public SumOfTopFiveRatings(Long sum) {
        this.sum = sum;
    }
}
