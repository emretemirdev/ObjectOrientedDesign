package com.emretemir.finalproject.RestAPI.repository;

import com.emretemir.finalproject.RestAPI.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends MongoRepository<Car, String> {

    List<Car> findAllByName(String name);
    Optional<Car> findByName(String name);



}
