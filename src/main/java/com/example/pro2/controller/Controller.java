package com.example.pro2.controller;

import com.example.pro2.Service.ResourceManagementService;
import com.example.pro2.model.Servers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    @Autowired
    public  final  ResourceManagementService resourceManagementService;

    public Controller(ResourceManagementService resourceManagementService) {
        this.resourceManagementService = resourceManagementService;
    }

    @GetMapping("/allocation")
    public void allocate(@RequestBody Servers servers) throws InterruptedException {
        resourceManagementService.allocate(servers.getId(), servers.getAmount());
    }


}