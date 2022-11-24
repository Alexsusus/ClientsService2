package com.example.clientsservice.controllers;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.services.data.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

import static com.example.clientsservice.models.Client.*;

@Controller
public class ClientUpdateController {
    @Autowired
    private ClientService clientService;
    @GetMapping("clientUpdate")
    public  String load(@RequestParam("clientId") Integer id, Model model){
        Client client = clientService.findById(id);
        model.addAttribute("client", client);
        Map<Gender,String> gender = new HashMap<>();
        for (Gender value : Gender.values()) {
            gender.put(value, value == client.getGender()?"selected" : "");
        }
        model.addAttribute("gender",gender);
        return "clientUpdate";
    }
}
