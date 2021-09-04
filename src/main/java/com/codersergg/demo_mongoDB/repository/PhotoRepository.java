package com.codersergg.demo_mongoDB.repository;

import com.codersergg.demo_mongoDB.model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhotoRepository extends MongoRepository<Photo, String> { }
