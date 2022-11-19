/*
package com.example.clientsservice.controllers;

import com.example.clientsservice.models.User;
import com.example.clientsservice.services.data.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class UsersController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String load() {
        return "redirect:users";
    }

    @GetMapping("users")
    public String loadClients(Model model) {
        List<User> list = userService.findAll();
        model.addAttribute("users",list);
        return "users";
    }

*/
/*    @PostMapping("userAddForm")
    public String clientAddForm(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("role") User.Role role,
            @RequestParam("status") User.Status status
    ){
        User user = new User(0,username,password,role,status);
        userService.save(user);
        return "redirect:";
    }*//*

}
*/
