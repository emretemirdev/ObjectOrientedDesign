package com.emretemir.finalproject.FinalProject.model;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {

    @Id //-> id alanının primary key olduğunu belirtmek için kullanılır.
    private String id;
    private String name;
    private int model;
    private Date createdDate = new Date();
}

  //-> @NoArgsConstructor @AllArgsConstructor yazarak Constructorları otomatik oluşturdum
 /*
 public Car() {
        this.id = id;
        this.name = name;
        this.model = model;
    }
    public Car(String id, String name, int model) {
        this.id = id;
        this.name = name;
        this.model = model;
    }
}
*/
