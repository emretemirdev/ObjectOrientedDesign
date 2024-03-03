package com.emretemir.finalproject.FinalProject.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {
    private String id;
    private String name;
    private int model;

 /*   public Car() {
        this.id = id;
        this.name = name;
        this.model = model;
    }
    public Car(String id, String name, int model) {
        this.id = id;
        this.name = name;
        this.model = model;
    }    -> -> -> @NoArgsConstructor @AllArgsConstructor yazarak Constructorları otomatik oluşturdum.
  */

}
