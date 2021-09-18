package com.example.demo.Service;

import com.example.demo.model.AppUser;
import com.example.demo.Repository.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private AppUserRepository appUserRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void addUser(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUser.setRole("ROLE_USER");
        appUserRepository.save(appUser);
    }

    public void deleteUserById(Long id) {
        boolean UserExist = appUserRepository.existsById(id);
        if(!UserExist){
            throw new IllegalStateException();
        }
        appUserRepository.deleteById(id);
    }

    public void deleteUserByUsername(String username) {
        Object object = appUserRepository.findByUsername(username);
        if(object==null){
            throw new IllegalStateException("Nie ma takiego uzytkownika");
        }
        appUserRepository.DeleteByUsername(username);
    }
}
