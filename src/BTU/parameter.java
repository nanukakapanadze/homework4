package com.company;

public class Parameter {
    private String name;
    private int minRange;
    private int maxRange;

    public Parameter(String name, int minRange, int maxRange) {
        this.name = name;
        this.minRange = minRange;
        this.maxRange = maxRange;
    }

    public Parameter(String name, String minRange, String maxRange) {
        this.name = name;
        this.minRange = Integer.parseInt(minRange);
        this.maxRange = Integer.parseInt(maxRange);
    }

    public String getName() {
        return name;
    }

    public int getMinRange() {
        return minRange;
    }

    public int getMaxRange() {
        return maxRange;
    }
}
