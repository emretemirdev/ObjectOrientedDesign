package com.emretemir.labapp;

import org.springframework.data.mongodb.repository.MongoRepository;

@org.springframework.stereotype.Repository

public interface Repository extends MongoRepository<User, String>{

}
