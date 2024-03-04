package com.emretemir.finalproject.FinalProject.repository;

import com.emretemir.finalproject.FinalProject.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<Car, String>{

}
