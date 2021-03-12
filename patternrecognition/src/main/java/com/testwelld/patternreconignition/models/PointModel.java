package com.testwelld.patternreconignition.models;

import com.testwelld.patternreconignition.views.PointView;

public class PointModel {
    private int y;
    private int x;

    //Constructor
    public PointModel(PointView pointView) {
        y = pointView.getY();
        x = pointView.getX();
    }

    //Getter
    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }

    //Setter
    public void setY(int y) {
        this.y = y;
    }
    public void setX(int x) {
        this.x = x;
    }

}
