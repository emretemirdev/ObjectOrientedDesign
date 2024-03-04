package com.emretemir.finalproject.FinalProject.repository;

import com.emretemir.finalproject.FinalProject.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends MongoRepository<Car, String> {

    List<Car> findAllByName(String name);
    Optional<Car> findByName(String name);



}
