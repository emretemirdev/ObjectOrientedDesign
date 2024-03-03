package com.emretemir.finalproject.FinalProject.controller;

import com.emretemir.finalproject.FinalProject.model.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final List<Car> cars;
    public CarController() {
        Car car1 = new Car("1","Honda",2004);
        Car car2 = new Car("2","Opel",2002);
        Car car3 = new Car("3","Mercedes",2005);
        cars = Arrays.asList(car1,car2,car3);
    }
    @GetMapping
    public ResponseEntity<List<Car>> getCars(){
        return new ResponseEntity<>(cars, OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarbyId(@PathVariable String id){
        //Java 8'den sonra gelen Stream API ile aşağıdaki kodu tek satırda yazıyoruz.
        Car result = cars.stream() // stream() metodu ile listeyi stream'e çeviriyoruz.
                .filter(car -> car.getId().equals(id))// id'si eşit olanı buluyoruz.
                .findFirst() // bulduğumuz ilk elemanı döndürüyoruz.
                .orElseThrow(() -> new RuntimeException("Car bulunamadı")); // eğer id bulunamazsa null döner.
        return new ResponseEntity<>(result, OK);

        /*
        Java 7'de aşağıdaki kodu yazıyorduk.
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getId().equals(id)){
                return new ResponseEntity<>(cars.get(i), OK);
            }
         if (i == cars.size()-1){
              throw new RuntimeException("Car bulunamadı");
          }
        }
        */


    }



}
