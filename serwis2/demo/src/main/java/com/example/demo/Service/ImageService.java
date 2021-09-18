package com.example.demo.Service;


import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.Repository.ImageRepository;
import com.example.demo.model.AppUser;
import com.example.demo.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class ImageService {

    private ImageRepository imageRepository;
    private Cloudinary cloudinary;
    @Autowired
    public ImageService(ImageRepository imageRepository){
        this.imageRepository=imageRepository;
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "",
                "api_key", "",
                "api_secret", ""));
    }
    public String uploadFileAndSave (String path){
        String User = SecurityContextHolder.getContext().getAuthentication().getName().toString();//zwracanie uzytkownika

        File file = new File(path);
        Map uploadResult = null;
        try {
            uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            imageRepository.save(new Image(uploadResult.get("url").toString(),User));
        } catch (IOException e) {
            // e.printStackTrace();
        }
        return uploadResult.get("url").toString();
    }


    public void deleteImage(String public_id){
        try {
             cloudinary.uploader().destroy(public_id,
                    ObjectUtils.emptyMap());
           imageRepository.DeleteByPath(public_id);
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }





}
