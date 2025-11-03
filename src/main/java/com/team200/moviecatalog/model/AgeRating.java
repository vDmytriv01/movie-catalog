package com.team200.moviecatalog.model;

public enum AgeRating {
    AGE_0(0),
    AGE_7(7),
    AGE_12(12),
    AGE_16(16),
    AGE_18(18);

    private final int value;

    AgeRating(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + "+";
    }
}
