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

import java.util.List;


@Controller
public class PhonesController {
    @Autowired
    private PhoneService phoneService;

    @GetMapping("phones")
    public String load(Model model) {
        List<Phone> list = phoneService.findAll();
        model.addAttribute("phones", list);
        return "phones";
    }

    @PostMapping("addPhoneForm")
    public String addPhoneForm(@ModelAttribute Phone phone) {
        phoneService.save(phone);
        return "redirect:phones";
    }

    @PostMapping("openPhoneForm")
    public ModelAndView openPhoneForm(@RequestParam("id") Integer id) {
        return new ModelAndView("redirect:phoneUpdate", new ModelMap("id", id));
    }
}

