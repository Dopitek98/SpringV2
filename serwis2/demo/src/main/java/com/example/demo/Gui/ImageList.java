package com.example.demo.Gui;

import com.example.demo.Repository.ImageRepository;
import com.example.demo.model.Image;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route("imagelist")
public class ImageList extends VerticalLayout {

    private ImageRepository imageRepository;

    @Autowired
    public ImageList(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
        List<Image> fullImageList = imageRepository.Imagelist();

        Grid<Image> grid = new Grid<>(Image.class);
        grid.setItems(fullImageList);
        add(grid);
    }

}
