package osr.monsterGenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import osr.monsterGenerator.Exceptions.NPCNotFoundException;
import osr.monsterGenerator.Exceptions.SystemNotSupportedException;
import osr.monsterGenerator.model.Systems;
import osr.monsterGenerator.model.npc.BaseNPC;
import osr.monsterGenerator.service.NPCService;

@RestController
@RequestMapping("/api/npc")
public class NPCController {

    @Autowired
    NPCService npcService;

    @GetMapping("/{systemName}")
    public BaseNPC generateSystemNPC(@PathVariable String systemName) {
        for (Systems system : Systems.values()) {
            if (systemName.equalsIgnoreCase(system.name()))
                return npcService.generateNPC(system);
        }

        throw new SystemNotSupportedException(systemName);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND,
            reason = "The requested system is currently not supported.  Please check your spelling, and try again if " +
                    "you believe this to be in error.")
    @ExceptionHandler(SystemNotSupportedException.class)
    public void systemNotSupportedError() {
    }

    @GetMapping("/saved/{npcId}")
    public BaseNPC getNPCById(@PathVariable String npcId) {
        // TODO Return error if(StringUtils.isStringNullOrBlank(npcId))
        BaseNPC result = npcService.getNPCById(npcId);
        if (result != null) return npcService.getNPCById(npcId);
        else throw new NPCNotFoundException(npcId);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND,
            reason = "The NPC with the given id was not found, or has been deleted after a period of disuse.  Please " +
                    "check your entry and try again. ")
    @ExceptionHandler(NPCNotFoundException.class)
    public void savedNPCNotFoundError() {
    }
}