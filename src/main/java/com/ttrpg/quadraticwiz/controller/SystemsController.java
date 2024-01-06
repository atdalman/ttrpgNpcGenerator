package com.ttrpg.quadraticwiz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ttrpg.quadraticwiz.model.Systems;

import java.util.ArrayList;


@RestController
@RequestMapping("/api")
public class SystemsController {

    @GetMapping("/systems")
    public ArrayList<String> getAllSystems() {
        ArrayList<String> systems = new ArrayList<>();
        for (Systems system : Systems.values()) {
            if (system.equals(Systems.BASE)) continue;
            systems.add(system.fullName);
        }
        return systems;
    }
}
