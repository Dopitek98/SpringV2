package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.GeneratedValue;
import java.security.Principal;

@Controller
public class UserController {
    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("hello")
    public String hello(Principal principal,Model model){
       model.addAttribute("name",principal.getName());
        return "hello";
    }

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
}
