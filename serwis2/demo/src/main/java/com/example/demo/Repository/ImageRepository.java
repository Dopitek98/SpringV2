package com.example.demo.Repository;


import com.example.demo.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {

    @Query("DELETE FROM Image WHERE Path LIKE '%path%'")
    Image existByPath(@Param("path") String path);

}
