package com.example.demo.Gui;

import com.example.demo.Service.ImageService;
import com.example.demo.Service.UserService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("AdminGui")
public class AdminGui extends VerticalLayout {

    private UserService userService;
    private ImageService imageService;

    @Autowired
    public AdminGui(UserService userService, ImageService imageService) {
        this.userService=userService;
        this.imageService = imageService;

        TextField DeleteById = new TextField();
        Button DeleteByIdButton = new Button("Delete User by Id");
        Label DeleteByIdLabel = new Label("Deleting user");

        TextField DeleteByUsername = new TextField();
        Button DeleteByUsernameButton = new Button("Delete User by username");
        Label DeleteByUsernameLabel = new Label("Deleting user by username");

        TextField textField2 = new TextField();
        Button imageDelete = new Button("Delete image by path");
        Label labeldelete = new Label("Deleting image");
      //  Text text = new Text("Testowy napis cos tam wyswietlajacy");

        DeleteByIdButton.addClickListener(buttonClickEvent ->{
            userService.deleteUserById(Long.valueOf(DeleteById.getValue()));
        });

        DeleteByUsernameButton.addClickListener(buttonClickEvent ->{
            userService.deleteUserByUsername((DeleteByUsername.getValue().toString()));
        });

        imageDelete.addClickListener(buttonClickEvent ->{
            imageService.deleteImage(textField2.getValue());
        });

        //delete User
        add(DeleteById);
        add(DeleteByIdButton);
        add(DeleteByIdLabel);

        add(DeleteByUsername);
        add(DeleteByUsernameButton);
        add(DeleteByUsernameLabel);
        //delete Image
        add(textField2);
        add(imageDelete);
        add(labeldelete);

    }


}


