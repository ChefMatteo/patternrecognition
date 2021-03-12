package com.testwelld.patternreconignition.services;

import com.testwelld.patternreconignition.DAO.PointDAO;
import com.testwelld.patternreconignition.models.PointModel;
import com.testwelld.patternreconignition.repositories.PointRepo;
import com.testwelld.patternreconignition.views.LinesView;
import com.testwelld.patternreconignition.views.PointView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PointsService {

    public ResponseEntity createPoint(PointModel pointModel, PointRepo pointRepo) {
            Optional<PointDAO> optionalPointDAO = pointRepo.findByYAndX(pointModel.getY(), pointModel.getX());
            if (optionalPointDAO.isPresent()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Point already exist.");
            } else {
                pointRepo.save(new PointDAO(pointModel));
                return ResponseEntity.status(HttpStatus.CREATED).body("Point created at the coordinates: "
                        + pointModel.getX() + "x, " + pointModel.getY() + "y.");
            }
    }

    public ResponseEntity<List<PointView>> showAllPoints(PointRepo pointRepo) {
        List<PointView> points = new ArrayList<>();
        pointRepo.findAll().spliterator().forEachRemaining(x-> points.add(new PointView(x.getY(),x.getX())));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(points);
    }

    public ResponseEntity<List<List<LinesView>>> getLines(PointRepo pointRepo, int n){
        List<PointView> points = new ArrayList<>();
        pointRepo.findAll().spliterator().forEachRemaining(x-> points.add(new PointView(x.getY(),x.getX())));
        ArrayList<LinesView> lines = new ArrayList<>();
        for(int i = 0; i < points.size()-1; i++){
            lines.add(new LinesView(points.get(i), points.get(i+1)));
        }

        List<List<LinesView>> equalsLines = new ArrayList<>();
        for(int i = 0; i < lines.size(); i++){
            ArrayList<LinesView> linesToAdd = new ArrayList<>();
            linesToAdd.add(lines.get(i));
            int counter = 1;
            for(int j = 0; j < lines.size(); j++){
                if(lines.get(i).equals(lines.get(j))){
                    linesToAdd.add(lines.get(j));
                    counter++;
                }
            }
            if(counter>=n)
                equalsLines.add(linesToAdd);
        }
        equalsLines.stream().findAny().get().stream().forEach(x->x.getListOfPoints().add(x.getBeginPoint()));
        equalsLines.stream().findAny().get().stream().forEach(x->x.getListOfPoints().add(x.getEndPoint()));
        return ResponseEntity.status(HttpStatus.OK).body(equalsLines);
    }

    public ResponseEntity deleteAll(PointRepo pointRepo){
        pointRepo.deleteAll();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("All points deleted.");
    }

}