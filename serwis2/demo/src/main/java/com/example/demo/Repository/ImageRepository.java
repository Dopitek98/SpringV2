package com.example.demo.Repository;


import com.example.demo.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Image WHERE Path LIKE %:path%",nativeQuery = true)
    void DeleteByPath(@Param("path") String path);

    @Query(value = "SELECT * FROM IMAGE",nativeQuery = true)
    List<Image> Imagelist();

    //@Query("UPDATE")

}
