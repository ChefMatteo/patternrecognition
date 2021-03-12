package com.testwelld.patternreconignition.repositories;

import com.testwelld.patternreconignition.DAO.PointDAO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PointRepo extends CrudRepository<PointDAO, Integer> {
    Optional<PointDAO> findByYAndX(Integer y, Integer x);

}
