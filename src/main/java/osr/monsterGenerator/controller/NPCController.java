package osr.monsterGenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import osr.monsterGenerator.model.Systems;
import osr.monsterGenerator.model.npc.BaseNPC;
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

    @GetMapping("/{systemName}")
    public BaseNPC generateSystemNPC(@PathVariable String systemName) {
        for (Systems system : Systems.values()) {
            if (systemName.equalsIgnoreCase(system.name())) {
                return npcService.generateNPC(system);
            }
        }

        //TODO Write exception
        return null;
    }

    @GetMapping("/saved/{npcId}")
    public BaseNPC getNPCById(@PathVariable String npcId) {
        // TODO Return error if(StringUtils.isStringNullOrBlank(npcId))
        return npcService.getNPCById(npcId);
    }
}