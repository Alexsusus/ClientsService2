/*
package com.example.clientsservice.controllers;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.services.data.ClientService;
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
public class ClientUpdateController {
    @Autowired
    private ClientService clientService;
    @GetMapping("clientUpdate")
    public  String load(@RequestParam("clientId") Integer id, Model model){
        Client client = clientService.findById(id);
        model.addAttribute("client", client);
       ModelMap genders = new ModelMap();
        for (Gender value : Gender.values()) {
            genders.put(value.name(), value==client.getGender() ? "selected" : "");
        }
        model.addAttribute("genders", genders.entrySet());
        return "clientUpdate";
    }

    @PostMapping("clientUpdateForm")
    public ModelAndView clientUpdateForm(@ModelAttribute("client") Client client){
        Client dbClient = clientService.findById(client.getId());
        client.setAddress(dbClient.getAddress());
        clientService.save(client);
        return new ModelAndView("redirect:clientUpdate",
                new ModelMap("clientId",client.getId()));
    }
}
*/
