package osr.monsterGenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import osr.monsterGenerator.Exceptions.SystemNotSupportedException;
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
            if (systemName.equalsIgnoreCase(system.name()))
                return npcService.generateNPC(system);
        }

        throw new SystemNotSupportedException(systemName);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND,
            reason = "The requested is currently not supported.  Please check your spelling, and try again if you believe this to be in error.")
    @ExceptionHandler(SystemNotSupportedException.class)
    public void generateSystemNPC_SystemNotFound() {
    }

    @GetMapping("/saved/{npcId}")
    public BaseNPC getNPCById(@PathVariable String npcId) {
        // TODO Return error if(StringUtils.isStringNullOrBlank(npcId))
        return npcService.getNPCById(npcId);
    }
}