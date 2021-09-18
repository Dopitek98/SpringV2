package com.example.demo.Gui;

import com.example.demo.Repository.ImageRepository;
import com.example.demo.Repository.PostRepository;
import com.example.demo.model.Image;
import com.example.demo.model.Post;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route("image1")
public class ImageTest extends VerticalLayout {
    private ImageRepository imageRepository;
    private PostRepository postRepository;

    @Autowired
    public ImageTest(ImageRepository imageRepository,PostRepository postRepository) {
        this.imageRepository = imageRepository;
        this.postRepository = postRepository;

        List<Image> list = imageRepository.findAll();

            com.vaadin.flow.component.html.Image image =
                    new com.vaadin.flow.component.html.Image(list.get(1).getPath(), "brak");
            add(image);


        List<Post> listPost = postRepository.findAll();

        Grid<Post> grid = new Grid<>(Post.class);
        grid.setItems(listPost);
        add(grid);


        TextField textField = new TextField();
        Button button = new Button("dodaj komentarz");

        button.addClickListener(buttonClickEvent ->{
            String Text = textField.getValue();
            postRepository.save(new Post(Text));
          //  postRepository.save(new Post(Text,list.get(1)));
            Label komentarz = new Label(Text);
            add(komentarz);
        });
        add(textField);
        add(button);

    }
}
