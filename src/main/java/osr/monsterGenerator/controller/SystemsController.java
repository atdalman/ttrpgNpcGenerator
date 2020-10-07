package osr.monsterGenerator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import osr.monsterGenerator.model.Systems;


@RestController
@RequestMapping("/api")
public class SystemsController {

    @GetMapping("/systems")
    public Systems[] getAllSystems() {
        return Systems.values();
    }
}
