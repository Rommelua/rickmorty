package com.rickmorty.service.loader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.rickmorty.dto.CharacterDto;
import com.rickmorty.model.Character;
import com.rickmorty.repository.CharacterRepository;
import com.rickmorty.service.mapper.DtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CharacterLoadServiceImpl implements CharacterLoadService {
    private final DtoMapper<Character, CharacterDto> mapper;
    private final CharacterRepository repository;
    private final RickAndMortyApiService apiService;

    @Value("${characters}")
    private String locationApiUrl;

    @Autowired
    public CharacterLoadServiceImpl(DtoMapper<Character, CharacterDto> mapper,
                                    CharacterRepository repository,
                                    RickAndMortyApiService apiService) {
        this.mapper = mapper;
        this.repository = repository;
        this.apiService = apiService;
    }

    @Override
    public void loadCharacters() {
        List<CharacterDto> dtos = apiService
                .getCartoonUnits(locationApiUrl, new TypeReference<>() {
                });
        List<Character> locations = dtos.stream()
                .map(mapper::mapToEntity)
                .collect(Collectors.toList());
        repository.saveAll(locations);
    }
}
