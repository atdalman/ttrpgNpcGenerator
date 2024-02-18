package com.ttrpg.quadraticwiz.controllers;

import com.ttrpg.quadraticwiz.domain.Systems;
import com.ttrpg.quadraticwiz.domain.npc.dtos.BaseNpc;
import com.ttrpg.quadraticwiz.exceptions.NpcNotFoundException;
import com.ttrpg.quadraticwiz.exceptions.SystemNotSupportedException;
import com.ttrpg.quadraticwiz.repositories.entities.BaseNpcEntity;
import com.ttrpg.quadraticwiz.services.api.NpcService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/npc")
@RequiredArgsConstructor
@Slf4j
public class NpcController {

    private final NpcService npcService;

    @GetMapping("/{systemName}")
    public BaseNpcEntity generateSystemNpc(@PathVariable String systemName,
                                           @RequestParam(required = false) String... tag) {
        for (Systems system : Systems.values()) {
            if (systemName.equalsIgnoreCase(system.name()))
                return npcService.generateNpc(system, tag);
        }

        log.info("Unsupported system requested: " + systemName);
        throw new SystemNotSupportedException(systemName);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND,
            reason = "The requested system is currently not supported.  Please check your spelling, and try again if " +
                    "you believe this to be in error.")
    @ExceptionHandler(SystemNotSupportedException.class)
    public void systemNotSupportedError() {
    }

    @GetMapping("/saved/{npcId}")
    public BaseNpc getNpcById(@PathVariable UUID npcId) {

        BaseNpc result = npcService.getNpcById(npcId);
        if (result != null) return npcService.getNpcById(npcId);
        else {
            log.info("Npc not found: " + npcId);
            throw new NpcNotFoundException(npcId);
        }
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND,
            reason = "The Npc with the given id was not found, or has been deleted after a period of disuse.  Please " +
                    "check your entry and try again. ")
    @ExceptionHandler(NpcNotFoundException.class)
    public void savedNpcNotFoundError() {
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST,
            reason = "Not a valid request.")
    @ExceptionHandler(IllegalArgumentException.class)
    public void badRequestError() {
    }


}