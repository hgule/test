package com.example.demo.mongo.api.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.mongo.api.model.test;

public interface testRepository extends MongoRepository<test,String> {

}
