package com.testwelld.patternreconignition.DAO;

import com.testwelld.patternreconignition.models.PointModel;
import com.testwelld.patternreconignition.views.PointView;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Optional;

@Entity
public class PointDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    private int y;
    private int x;

    public PointDAO(){
    }
    public PointDAO(PointModel pointModel) {
        y = pointModel.getY();
        x = pointModel.getX();
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
