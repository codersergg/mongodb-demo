package com.codersergg.demo_mongoDB.service;

import com.codersergg.demo_mongoDB.model.Photo;
import com.codersergg.demo_mongoDB.repository.PhotoRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PhotoService {

    private final PhotoRepository photoRepo;

    public PhotoService(PhotoRepository photoRepo) {
        this.photoRepo = photoRepo;
    }

    public String addPhoto(String title, MultipartFile file) throws IOException {
        Photo photo = new Photo(title);
        photo.setImage(
                new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        photo = photoRepo.insert(photo);
        return photo.getId();
    }

    public Photo getPhoto(String id) {
        return photoRepo.findById(id).get();
    }
}
