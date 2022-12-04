
package com.example.clientsservice.controllers;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.models.User;
import com.example.clientsservice.services.data.ClientService;
import com.example.clientsservice.services.data.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



import static com.example.clientsservice.models.Client.*;

@Controller
public class UserUpdateController {
    @Autowired
    private UserService userService;
    @GetMapping("userUpdate")
    public  String load(@RequestParam("userId") Integer id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);

       ModelMap roles = new ModelMap();
        for (User.Role value : User.Role.values()) {
            roles.put(value.name(), value==user.getRole() ? "selected" : "");
        }
        model.addAttribute("roles", roles.entrySet());
        ModelMap statuses = new ModelMap();
        for (User.Status value : User.Status.values()) {
            statuses.put(value.name(), value==user.getStatus() ? "selected" : "");
        }
        model.addAttribute("statuses", statuses.entrySet());

        return "userUpdate";
    }

    @PostMapping("userUpdateForm")
    public ModelAndView userUpdateForm(@ModelAttribute("user") User user){
        userService.save(user);
        return new ModelAndView("redirect:userUpdate",
                new ModelMap("userId",user.getId()));
    }
}

