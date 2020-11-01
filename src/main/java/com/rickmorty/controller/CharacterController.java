package com.rickmorty.controller;

import com.rickmorty.dto.CharacterDto;
import com.rickmorty.model.Character;
import com.rickmorty.service.CharacterService;
import com.rickmorty.service.loader.DataLoadService;
import com.rickmorty.service.mapper.DtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/character")
public class CharacterController {
    private final DataLoadService dataLoadService;
    private final CharacterService characterService;
    private final DtoMapper<Character, CharacterDto> mapper;

    @Autowired
    public CharacterController(DataLoadService dataLoadService,
                               CharacterService characterService,
                               DtoMapper<Character, CharacterDto> mapper) {
        this.dataLoadService = dataLoadService;
        this.characterService = characterService;
        this.mapper = mapper;
    }

    @GetMapping("/random")
    public CharacterDto getRandom() {
        Character character = characterService.getRandomCharacter();
        return mapper.mapToDto(character);
    }

    @GetMapping("/by-name-contains")
    public List<CharacterDto> getByNameContains(@RequestParam String query) {
        return characterService.findByNameContains(query).stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }
}
