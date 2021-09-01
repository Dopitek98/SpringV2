package com.example.demo.Gui;

import com.example.demo.Service.ImageUpload;
import com.example.demo.Service.UserService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("AdminGui")
public class AdminGui extends VerticalLayout {

    private UserService userService;
    private ImageUpload imageUpload;

    @Autowired
    public AdminGui(UserService userService,ImageUpload imageUpload) {
        this.userService=userService;
        this.imageUpload=imageUpload;

        TextField textField = new TextField();
        Button button = new Button("Delete User by Id");
        Label label = new Label("Deleting user");

        TextField textField2 = new TextField();
        Button imageDelete = new Button("Delete image by path");
        Label labeldelete = new Label("Deleting image");

        button.addClickListener(buttonClickEvent ->{
            userService.deleteUser(Long.valueOf(textField.getValue()));
        });
        imageDelete.addClickListener(buttonClickEvent ->{
            imageUpload.deleteImage(textField2.getValue());
        });
        //delete User add
        add(textField);
        add(button);
        add(label);
        //delete Image add
        add(textField2);
        add(imageDelete);
        add(labeldelete);
    }


}


