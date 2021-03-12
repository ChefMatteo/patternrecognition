package com.testwelld.patternreconignition.views;

import java.util.*;

public class LinesView {
    private PointView beginPoint;
    private PointView endPoint;
    private List<PointView> listOfPoints;
    private double slope;

    //Constructor
    public LinesView(PointView beginPoint, PointView endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
        slope = slopeCalculation(beginPoint, endPoint);
        listOfPoints = new ArrayList<>();
    }


    //Getters
    public PointView getBeginPoint() {
        return beginPoint;
    }
    public PointView getEndPoint() {
        return endPoint;
    }
    public double getSlope() {
        return slope;
    }
    public List<PointView> getListOfPoints() {
        return listOfPoints;
    }

    //Setters
    public void setBeginPoint(PointView beginPoint) {
        this.beginPoint = beginPoint;
    }
    public void setEndPoint(PointView endPoint) {
        this.endPoint = endPoint;
    }
    public void setSlope(double slope) {
        this.slope = slope;
    }
    public void setListOfPoints(List<PointView> listOfPoints) {
        this.listOfPoints = listOfPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinesView linesModel = (LinesView) o;
        return Double.compare(linesModel.slope, slope) == 0;
    }
    @Override
    public int hashCode() {
        return Objects.hash(slope);
    }

    private double slopeCalculation(PointView pointView1, PointView pointView2){
        return (double)(pointView1.getY()- pointView2.getY())/(double)(pointView1.getX()- pointView2.getX());
    }


}
