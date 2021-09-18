package com.example.demo.Gui;

import com.cloudinary.Transformation;
import com.example.demo.Repository.ImageRepository;
import com.example.demo.model.Image;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.List;

@Route("gallery")
public class GuiGallery extends VerticalLayout{

    private ImageRepository imageRepository;

    @Autowired
    public GuiGallery(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;

        List<Image> list = imageRepository.findAll();
        list.stream().forEach(element -> {
            com.vaadin.flow.component.html.Image image =
                    new com.vaadin.flow.component.html.Image(element.getPath(), "brak");
            add(image);
        });
    }
}


