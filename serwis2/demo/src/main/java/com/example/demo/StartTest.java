package com.example.demo;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class StartTest {


    public StartTest(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {

        AppUser appUser = new AppUser();
        appUser.setUsername("Magik");
        appUser.setPassword(passwordEncoder.encode("1234"));
        appUser.setRole("USER");
        appUserRepository.save(appUser);

        AppUser appUser2 = new AppUser();
        appUser2.setUsername("Czarodziej");
        appUser2.setPassword(passwordEncoder.encode("1234"));
        appUser2.setRole("ADMIN");
        appUserRepository.save(appUser2);
    }


}
