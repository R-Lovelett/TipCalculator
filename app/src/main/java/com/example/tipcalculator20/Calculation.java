package com.example.tipcalculator20;

public class Calculation {

    public double individualTip(double tip, double percentage) {
        double totalTip = tip * percentage;
        return totalTip;
    }

    public double groupTip(int size, double tip) {
        double perPersonTip = tip / size;
        return perPersonTip;
    }
}
