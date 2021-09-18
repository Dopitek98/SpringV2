package com.example.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.model.AppUser;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByUsername(String username);

    @Query("Select s From AppUser s WHERE s.id =?1")
    Optional<AppUser> existById(Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM App_User WHERE USERNAME =:username",nativeQuery = true)
    void DeleteByUsername(@Param("username") String username);

    @Query(value = "Select FROM App_User WHERE username=:username",nativeQuery = true)
    boolean findUserByUsername(@Param("username") String username);
}
