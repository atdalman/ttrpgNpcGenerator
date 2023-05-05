package ttrpg.monsterGenerator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ttrpg.monsterGenerator.exceptions.NPCNotFoundException;
import ttrpg.monsterGenerator.exceptions.SystemNotSupportedException;
import ttrpg.monsterGenerator.model.Systems;
import ttrpg.monsterGenerator.model.npc.BaseNPC;
import ttrpg.monsterGenerator.service.NPCService;
import ttrpg.monsterGenerator.utilities.StringUtils;

@RestController
@RequestMapping("/api/npc")
public class NPCController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NPCController.class);

    @Autowired
    NPCService npcService;

    @GetMapping("/{systemName}")
    public BaseNPC generateSystemNPC(@PathVariable String systemName,
                                     @RequestParam(required = false) String... tag) {
        for (Systems system : Systems.values()) {
            if (systemName.equalsIgnoreCase(system.name()))
                return npcService.generateNPC(system, tag);
        }

        LOGGER.error("Unsupported system requested: " + systemName);
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
        if (StringUtils.isStringNullOrBlank(npcId)) throw new IllegalArgumentException("Request does not include a " +
                "valid NPC Id: " + npcId);
        BaseNPC result = npcService.getNPCById(npcId);
        if (result != null) return npcService.getNPCById(npcId);
        else {
            LOGGER.debug("NPC not found: " + npcId);
            throw new NPCNotFoundException(npcId);
        }
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND,
            reason = "The NPC with the given id was not found, or has been deleted after a period of disuse.  Please " +
                    "check your entry and try again. ")
    @ExceptionHandler(NPCNotFoundException.class)
    public void savedNPCNotFoundError() {
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST,
            reason = "Not a valid request.")
    @ExceptionHandler(IllegalArgumentException.class)
    public void badRequestError() {
    }


}