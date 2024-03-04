package com.emretemir.finalproject.FinalProject.service;

import com.emretemir.finalproject.FinalProject.model.Car;
import com.emretemir.finalproject.FinalProject.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class CarService {

    private final CarRepository carRepostiroy;
    //final kullanmamın sebebi, bu değişkenin bir kere set edilmesi ve bir daha değiştirilmemesi gerektiğini belirtmek içindir.
    public List<Car> getCars(){
        return carRepostiroy.findAll();
    }

    public void createCar(Car newCar) {
        newCar.setCreatedDate(new Date());
        carRepostiroy.save(newCar);
    }

    public void deleteCarById(String id) {
        carRepostiroy.deleteById(id);
    }

    public Car getCarById(String id) {
      return carRepostiroy.findById(id)
        .orElseThrow(() -> new RuntimeException("Car not found"));

        /* Bu karmaşık kod yerine yukarıdaki kodu yazdım ve aynı işi yapıyor.

        Optional<Car> car = carRepostiroy.findById(id);
        if(car.isEmpty()){
            throw new RuntimeException("Car not found");
        }
        return car.get();
         */
    }
}
