package de.controller.data_retrieve_controller;

import de.data_models.data_transfer_objects.RaceResult;
import de.data_models.entities.Dog;

import java.util.Comparator;

public class RaceResultComparator implements  Comparator<RaceResult>  {
    @Override
    public int compare(RaceResult o1, RaceResult o2) {
        return Integer.parseInt(o1.getTotalPoints()) - Integer.parseInt(o2.getTotalPoints());
    }
}



