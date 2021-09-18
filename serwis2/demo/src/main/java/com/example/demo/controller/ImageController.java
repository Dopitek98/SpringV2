package com.example.demo.controller;

import com.example.demo.Service.ImagePageService;
import com.example.demo.Service.ImageService;
import com.example.demo.model.Image;
import com.example.demo.model.ImagePage;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ImageController {
    private ImageService imageService;
    private ImagePageService imagePageService;

    public ImageController(ImageService imageService, ImagePageService imagePageService) {
        this.imageService = imageService;
        this.imagePageService = imagePageService;
    }

    @GetMapping("/test")
    //todo modify /test mapping
    public ResponseEntity<Page<Image>> getAllImages(ImagePage imagePage){
        return new ResponseEntity<>(imagePageService.getImage(imagePage), HttpStatus.OK);
    }
}
