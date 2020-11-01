package com.rickmorty.service;

import com.rickmorty.model.Character;
import java.util.List;

public interface CharacterService {

    Character getRandomCharacter();

    List<Character> findByNameContains(String query);
}
