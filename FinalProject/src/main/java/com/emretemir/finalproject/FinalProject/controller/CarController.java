package com.emretemir.finalproject.FinalProject.controller;

import com.emretemir.finalproject.FinalProject.exception.CarsAlreadyException;
import com.emretemir.finalproject.FinalProject.exception.CarsNotFoundException;
import com.emretemir.finalproject.FinalProject.model.Car;
import com.emretemir.finalproject.FinalProject.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/cars")
@AllArgsConstructor
public class CarController {

    private final CarService carService;
    @GetMapping
    //Search Query Parametreleri ile filtreleme yapmak için @RequestParam anotasyonunu kullanıyorm
    public ResponseEntity<List<Car>> getCars(@RequestParam(required = false) String name){
        return new ResponseEntity<>(carService.getCars(name), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarbyId(@PathVariable String id){
        //Java 8'den sonra gelen Stream API ile aşağıdaki kodu tek satırda yazıyoruz.
        Car result = getCarById(id);
        return new ResponseEntity<>(result, OK);
    }

    @PostMapping
    public ResponseEntity<Car> addCar(@RequestBody Car newCar){
        carService.createCar(newCar);
        return new ResponseEntity<>(newCar, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> getCarById(@PathVariable String id, @RequestBody Car updatedCar){
        Car car = getCarById(id);
        car.setName(updatedCar.getName());
        car.setModel(updatedCar.getModel());

        carService.updateCar(id,car);
        return new ResponseEntity<>(OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarById(@PathVariable String id){
          carService.deleteCarById(id);
        return new ResponseEntity<>(OK);
    }

    //getCarById metodunu 3 kez kullandım. Kod tekrarı olmaması için bu metodu oluşturdum
    private Car getCarById(String id) {
        return carService.getCarById(id);
    }


    @ExceptionHandler(CarsAlreadyException.class)
    public ResponseEntity<String> handleCarsAlreadyException(Exception e){
        return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
    }

    @ExceptionHandler(CarsNotFoundException.class)
    public ResponseEntity<String> handleCarsNotFoundException(Exception e){
        return new ResponseEntity<>(e.getMessage(),NOT_FOUND);
    }
}
