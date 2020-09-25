package osr.monsterGenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import osr.monsterGenerator.model.Systems;
import osr.monsterGenerator.service.NPCService;

@RestController
@RequestMapping("/api/npc")
public class NPCController {

    @Autowired
    NPCService npcService;

    @GetMapping("/")
    public String generateBaseNPC() {
        return npcService.generateBaseNPC().toString();
    }

    @GetMapping("/{system}")
    public String generateSystemNPC(@PathVariable String system) {
        return npcService.generateNPC(Systems.valueOf(system)).toString();
    }

    @GetMapping("/{npcId}")
    public String getNPCById(@PathVariable String npcId) {
        // Return error if(StringUtils.isStringNullOrBlank(npcId))
        return npcService.getNPCById(npcId).toString();
    }


}