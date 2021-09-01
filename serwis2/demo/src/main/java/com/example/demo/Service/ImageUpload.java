package com.example.demo.Service;


import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.Repository.ImageRepository;
import com.example.demo.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@Service
public class ImageUpload {

    private ImageRepository imageRepository;
    private Cloudinary cloudinary;

    @Autowired
    public ImageUpload(ImageRepository imageRepository){
        this.imageRepository=imageRepository;
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "",
                "api_key", "",
                "api_secret", ""));
    }
    public String uploadFileAndSave (String path){
        File file = new File(path);
        Map uploadResult = null;
        try {
            uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            imageRepository.save(new Image(uploadResult.get("url").toString()));
        } catch (IOException e) {
            // e.printStackTrace();
        }
        return uploadResult.get("url").toString();
    }

    public void deleteImage(String public_id){
        Map delete = null;
        try {
            //Working can delete
             delete = cloudinary.uploader().destroy(public_id,
                    ObjectUtils.emptyMap());
            //todo debug what is public id
           // imageRepository.existByPath(delete.get("url").toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
