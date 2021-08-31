package com.example.demo.Gui;

import com.example.demo.Repository.ImageRepository;
import com.example.demo.model.Image;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.Service.ImageUpload;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route("gallery")
public class GuiGallery extends VerticalLayout {

    private ImageRepository imageRepository;

    @Autowired
    public GuiGallery(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;

        List<Image> list = imageRepository.findAll();
        list.stream().forEach(element->{
            com.vaadin.flow.component.html.Image image =
                    new com.vaadin.flow.component.html.Image(element.getPath(),"brak");
                    add(image);
        });
    }
}
