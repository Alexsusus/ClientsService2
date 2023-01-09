package com.example.clientsservice.controllers;

import com.example.clientsservice.models.Phone;
import com.example.clientsservice.services.data.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PhoneUpdateController {
    @Autowired
    private PhoneService phoneService;

    @GetMapping("phoneUpdate")
    public String load(@RequestParam("id") Integer id, Model model) {
        Phone phone = phoneService.findById(id);
        model.addAttribute("phone", phone);
        return "phoneUpdate";
    }

    @PostMapping("updatePhoneForm")
    public ModelAndView updatePhoneForm(@ModelAttribute Phone phone) {
        phoneService.save(phone);
        return new ModelAndView("redirect:phoneUpdate",
                new ModelMap("id", phone.getId()));
    }
}
