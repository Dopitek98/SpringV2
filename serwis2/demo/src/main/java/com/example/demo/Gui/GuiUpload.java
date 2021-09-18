package com.example.demo.Gui;


import com.example.demo.Service.ImageService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route("upload")
public class GuiUpload extends VerticalLayout {

    private ImageService imageService;

    @Autowired
    public GuiUpload(ImageService imageService) {
        this.imageService = imageService;

        TextField textField = new TextField();
        Button button = new Button("upload");
        Label label = new Label();


        button.addClickListener(buttonClickEvent ->{

            String uploadImage = imageService.uploadFileAndSave(textField.getValue());
            Image image = new Image(uploadImage,"brak obrazka");
            label.setText("Obrazek wrzucony");
            add(label);
            add(image);
        });
        add(textField);
        add(button);
    }


}
