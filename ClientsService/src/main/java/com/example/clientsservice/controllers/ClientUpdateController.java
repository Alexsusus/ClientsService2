package com.example.clientsservice.controllers;

import com.example.clientsservice.models.Address;
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

@Controller
public class ClientUpdateController {
    @Autowired
    private ClientService clientService;

    @GetMapping("clientUpdate")
    public String load(@RequestParam("id") Integer id, Model model) {
        Client client = clientService.findById(id);
        model.addAttribute("client", client);
        model.addAttribute("genders", Client.Gender.values());
        return "clientUpdate";
    }

    @PostMapping("updateClientForm")
    public ModelAndView updateClientForm(@ModelAttribute Client client) {
        clientService.save(client);
        return new ModelAndView("redirect:clientUpdate",
                new ModelMap("id", client.getId()));
    }

    @PostMapping("updateClientAddressForm")
    public ModelAndView updateClientAddressForm(
            @ModelAttribute Client client,
            @ModelAttribute Address address
    ) {
        System.err.println(client);
        System.err.println(address);
        return new ModelAndView("redirect:clientUpdate",
                new ModelMap("id", client.getId()));
    }

}
