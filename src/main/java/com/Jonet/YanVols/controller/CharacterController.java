package com.Jonet.YanVols.controller;

import com.Jonet.YanVols.model.Character;
import com.Jonet.YanVols.service.CharacterService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/v1/characters")
    @ManagedOperation(description = "Lists All Characters")
    public ResponseEntity<List<Character>> listCharacters(){
        return new ResponseEntity<>(characterService.findAll(), HttpStatusCode.valueOf(200));
    }


    @PostMapping("/v1/characters")
    @ManagedOperation(description = "Create One Character")
    public ResponseEntity<Character> listCharacters(@RequestBody CharacterDTO characterDTO){
        return new ResponseEntity<>(characterService.createCharacter(characterDTO.getName(),
                characterDTO.getRarity()), HttpStatusCode.valueOf(200));
    }

}
