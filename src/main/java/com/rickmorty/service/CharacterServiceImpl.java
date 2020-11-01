package com.rickmorty.service;

import com.rickmorty.model.Character;
import com.rickmorty.repository.CharacterRepository;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl implements CharacterService {
    private final CharacterRepository repository;

    @Autowired
    public CharacterServiceImpl(CharacterRepository repository) {
        this.repository = repository;
    }

    @Override
    public Character getRandomCharacter() {
        int numberOfCharacters = (int) repository.count();
        long randomId = new Random().nextInt(numberOfCharacters) + 1;
        return repository.findById(randomId).get();
    }

    @Override
    public List<Character> findByNameContains(String query) {
        return repository.findByNameContainingIgnoreCase(query);
    }
}
