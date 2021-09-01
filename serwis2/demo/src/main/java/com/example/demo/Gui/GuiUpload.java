package com.example.demo.Gui;


import com.example.demo.Service.ImageUpload;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.io.File;


@Route("upload")
public class GuiUpload extends VerticalLayout {

    private ImageUpload imageUpload;

    @Autowired
    public GuiUpload(ImageUpload imageUpload) {
        this.imageUpload = imageUpload;

        TextField textField = new TextField();
        Button button = new Button("upload");
        Label label = new Label();


        button.addClickListener(buttonClickEvent ->{

            String uploadImage = imageUpload.uploadFileAndSave(textField.getValue());
            Image image = new Image(uploadImage,"brak obrazka");
            label.setText("Obrazek wrzucony");
            add(label);
            add(image);
        });
        add(textField);
        add(button);
    }


}
