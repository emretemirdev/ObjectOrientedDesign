package com.emretemir.finalproject.FinalProject.service;

import com.emretemir.finalproject.FinalProject.exception.CarsAlreadyException;
import com.emretemir.finalproject.FinalProject.exception.CarsNotFoundException;
import com.emretemir.finalproject.FinalProject.model.Car;
import com.emretemir.finalproject.FinalProject.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarService {

    private final CarRepository carRepostiroy;
    //final kullanmamın sebebi, bu değişkenin bir kere set edilmesi ve bir daha değiştirilmemesi gerektiğini belirtmek içindir.

    public List<Car> getCars(String name){
        if(name == null){
            return carRepostiroy.findAll();
        }
        return carRepostiroy.findAllByName(name);
    }

    public void createCar(Car newCar) {
      Optional<Car> carByName = carRepostiroy.findByName(newCar.getName());
      if (carByName.isPresent()) {
        throw new CarsAlreadyException("Car already exists with name: " + newCar.getName());
      }
        carRepostiroy.save(newCar);
    }

    public void deleteCarById(String id) {
        carRepostiroy.deleteById(id);
    }

    public Car getCarById(String id) {
      return carRepostiroy.findById(id)
        .orElseThrow(() -> new CarsNotFoundException("Car not found with id: " + id));

        /* Bu karmaşık kod yerine yukarıdaki kodu yazdım ve aynı işi yapıyor.

        Optional<Car> car = carRepostiroy.findById(id);
        if(car.isEmpty()){
            throw new RuntimeException("Car not found");
        }
        return car.get();
         */
    }

    public void updateCar(String id, Car newCar) {
        Car oldCar = getCarById(id);
        oldCar.setName(newCar.getName());
        carRepostiroy.save(oldCar);
    }
}
