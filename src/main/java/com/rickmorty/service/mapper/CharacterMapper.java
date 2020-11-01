package com.rickmorty.service.mapper;

import com.rickmorty.dto.CharacterDto;
import com.rickmorty.model.Character;
import com.rickmorty.model.Episode;
import com.rickmorty.repository.EpisodeRepository;
import com.rickmorty.repository.LocationRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CharacterMapper implements DtoMapper<Character, CharacterDto> {
    private final EpisodeRepository episodeRepository;
    private final LocationRepository locationRepository;

    @Autowired
    public CharacterMapper(EpisodeRepository episodeRepository,
                           LocationRepository locationRepository) {
        this.episodeRepository = episodeRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public Character mapToEntity(CharacterDto dto) {
        Character character = new Character();
        setEntityFields(character, dto);
        character.setStatus(dto.getStatus());
        character.setSpecies(dto.getSpecies());
        character.setType(dto.getType());
        character.setGender(dto.getGender());
        character.setOrigin(locationRepository.getByUrl(dto.getOrigin().getUrl()));
        character.setLocation(locationRepository.getByUrl(dto.getLocation().getUrl()));
        character.setImage(dto.getImage());
        List<Episode> episodes = dto.getEpisode().stream()
                .map(episodeRepository::getByUrl)
                .collect(Collectors.toList());
        character.setEpisode(episodes);
        return character;
    }

    @Override
    public CharacterDto mapToDto(Character character) {
        CharacterDto dto = new CharacterDto();
        setDtoFields(character, dto);
        dto.setStatus(character.getStatus());
        dto.setSpecies(character.getSpecies());
        dto.setType(character.getType());
        dto.setGender(character.getGender());
        String originName = character.getOrigin() == null ? null : character.getOrigin().getName();
        String originUrl = character.getOrigin() == null ? null : character.getOrigin().getUrl();
        CharacterDto.LocationInCharacterDto origin
                = new CharacterDto.LocationInCharacterDto(originName, originUrl);
        dto.setOrigin(origin);
        String locationName = character.getLocation() == null ? null
                : character.getLocation().getName();
        String locationUrl = character.getLocation() == null ? null
                : character.getLocation().getUrl();
        CharacterDto.LocationInCharacterDto location
                = new CharacterDto.LocationInCharacterDto(locationName, locationUrl);
        dto.setLocation(location);
        dto.setImage(character.getImage());
        List<String> episodes = character.getEpisode().stream()
                .map(Episode::getUrl)
                .collect(Collectors.toList());
        dto.setEpisode(episodes);
        return dto;
    }
}
