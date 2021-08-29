package com.example.tipcalculator20;

/**
 * This class performs the math calculations to determine the amount
 * of desired tip to leave.
 * @author Randi L.
 */
public class Calculation {

    /**
     * Performs multiplication to determine total tip an individual could leave.
     * @param bill Total bill amount in double format
     * @param percentage Percentage tip desired in double format
     * @return Total individual tip
     */
    public double individualTip(double bill, double percentage) {
        double totalTip = bill * percentage;
        return totalTip;
    }

    /**
     * Performs division of individual tip to determine tip for each person in a group of people.
     * @param size Number of people to split tip
     * @param tip Total tip calculated in double format
     * @return Total tip for each person in a group
     */
    public double groupTip(int size, double tip) {
        double perPersonTip = tip / size;
        return perPersonTip;
    }
}
