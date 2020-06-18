package osr.monsterGenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import osr.monsterGenerator.service.NPCFactory;

@RestController
@RequestMapping("/api/npc")
public class NPCController {

    @Autowired
    NPCFactory npcfactory;

    @GetMapping("/base")
    public String generateBaseNPC() {
        return npcfactory.generateBaseNPC().toString();
    }

}