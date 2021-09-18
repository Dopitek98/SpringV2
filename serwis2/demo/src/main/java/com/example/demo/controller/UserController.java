package com.example.demo.controller;

import com.example.demo.Service.ImageService;
import com.example.demo.model.AppUser;
import com.example.demo.Service.UserService;
import com.example.demo.model.Image;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {
    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String hello(Principal principal,Model model){
       model.addAttribute("name",principal.getName());
        return "hello";
    }
    /*
    @Transactional
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }*/

    @GetMapping("/sign-up")
    public String signup(Model model){
        model.addAttribute("user",new AppUser());
        return "sign-up.html";
    }

    @PostMapping("/register")
    public String register(AppUser appUser){
        userService.addUser(appUser);
        return "sign-up";
    }
/*
    @GetMapping("/gallery")
    public ResponseEntity<List<Image>> getAllEmployees(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
      List<Image> list = ImageService.getAllEmployees(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<Image>>(list, new HttpHeaders(), HttpStatus.OK);
    }

 */
}
