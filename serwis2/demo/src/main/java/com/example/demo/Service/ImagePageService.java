package com.example.demo.Service;

import com.example.demo.Repository.ImageRepository;
import com.example.demo.model.Image;
import com.example.demo.model.ImagePage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagePageService {

    private final ImageRepository imageRepository;

    public ImagePageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Page<Image> getImage(ImagePage imagePage){
        Sort sort = Sort.by(imagePage.getSortDirection(),imagePage.getSortBy());
        Pageable pageable = PageRequest.of(imagePage.getPageNumber()
                ,imagePage.getPageSize()
                ,sort);

        List<Image> list = imageRepository.findAll();

        return imageRepository.findAll(pageable);
    }
}
