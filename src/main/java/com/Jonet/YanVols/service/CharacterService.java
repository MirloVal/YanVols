package com.Jonet.YanVols.service;

import com.Jonet.YanVols.exceptions.YanVolsException;
import com.Jonet.YanVols.model.Character;
import com.Jonet.YanVols.model.Rarity;
import com.Jonet.YanVols.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public Character createCharacter(String name, Rarity rarity){
        Character character = new Character();
        character.setName(name);
        character.setRarity(rarity);
        return characterRepository.save(character);
    }

    public List<Character> findAll() {
        List<Character> list = characterRepository.findAll();
        if (list.isEmpty()){
            throw new YanVolsException("Not Characters Found", NOT_FOUND);
        }
        return characterRepository.findAll();
    }

    public Character getCharacter(Long id) {
        return characterRepository.findById(id).orElseThrow(()-> new YanVolsException("Character not found", NOT_FOUND));
    }
}
