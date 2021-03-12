package com.testwelld.patternreconignition.views;

import java.util.Objects;

public class PointView {
    private int y;
    private int x;

    //Constructor
    public PointView(int y, int x) {
        this.y = y;
        this.x = x;
    }

    //Getters
    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }

    //Setters
    public void setY(int y) {
        this.y = y;
    }
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointView pointView = (PointView) o;
        return y == pointView.y &&
                x == pointView.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }
}

