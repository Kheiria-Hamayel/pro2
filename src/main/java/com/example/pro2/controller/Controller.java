package com.example.pro2.controller;

import com.example.pro2.Service.ResourceManagementService;
import com.example.pro2.model.Servers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class Controller {

    @Autowired
    public  final  ResourceManagementService resourceManagementService;

    public Controller(ResourceManagementService resourceManagementService) {
        this.resourceManagementService = resourceManagementService;
    }

    @GetMapping("/allocation")
    public void allocate() throws InterruptedException {
        resourceManagementService.allocate(1, 10);
        resourceManagementService.allocate(2,10);
        resourceManagementService.allocate(3,10);
        resourceManagementService.allocate(4,10);
        resourceManagementService.allocate(5,5);
        //resourceManagementService.allocate(6,5);
//memory in total 5
    }

    @GetMapping("/allocation2")
    public void allocate2() throws InterruptedException {

        resourceManagementService.allocate(7,10);
        resourceManagementService.allocate(8,2);

    }
    @GetMapping("/allocation3")
    public void allocate3() throws InterruptedException {


        resourceManagementService.allocate(9,3);

    }


}
