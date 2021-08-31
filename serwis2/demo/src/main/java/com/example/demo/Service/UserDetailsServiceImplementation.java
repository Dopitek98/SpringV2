package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.AppUserRepository;
@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    AppUserRepository appUserRepository;

    @Autowired
    public UserDetailsServiceImplementation(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return appUserRepository.findByUsername(s).get();
    }
}
