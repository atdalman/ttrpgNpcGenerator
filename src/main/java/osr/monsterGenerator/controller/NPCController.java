package osr.monsterGenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import osr.monsterGenerator.model.Systems;
import osr.monsterGenerator.service.NPCFactory;

@RestController
@RequestMapping("/api/npc")
public class NPCController {

    @Autowired
    NPCFactory npcfactory;

    @GetMapping("/")
    public String generateBaseNPC() {
        return npcfactory.generateBaseNPC().toString();
    }

    @GetMapping("/{system}")
    public String generateSystemNPC(@PathVariable Systems system) {
        return npcfactory.generateNPC(system).toString();
    }


}