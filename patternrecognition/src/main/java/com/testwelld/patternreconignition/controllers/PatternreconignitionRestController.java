package com.testwelld.patternreconignition.controllers;

import com.testwelld.patternreconignition.models.PointModel;
import com.testwelld.patternreconignition.repositories.PointRepo;
import com.testwelld.patternreconignition.services.PointsService;
import com.testwelld.patternreconignition.views.LinesView;
import com.testwelld.patternreconignition.views.PointView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class PatternreconignitionRestController {
    @Autowired
    private PointRepo pointRepo;

    @PostMapping(value = "/point")
    ResponseEntity<PointView> addPoint(@RequestBody PointView pointView,
                                       @Autowired PointsService pointsService){
            PointModel pointModel = new PointModel(pointView);
            return pointsService.createPoint(pointModel, pointRepo);
    }

    @GetMapping(value = "/space")
    ResponseEntity<List<PointView>> showAllPoints(@Autowired PointsService pointsService){
        return pointsService.showAllPoints(pointRepo);
    }

    @GetMapping(value = "/lines/{n}")
    ResponseEntity<List<List<LinesView>>> showLines(@Autowired PointsService pointsService,
                                              @PathVariable("n") int numbersOfPoints){
        return pointsService.getLines(pointRepo, numbersOfPoints);
    }

    @DeleteMapping(value = "/space")
    ResponseEntity<PointView> deletePoints(@Autowired PointsService pointsService){
        return pointsService.deleteAll(pointRepo);
    }
}