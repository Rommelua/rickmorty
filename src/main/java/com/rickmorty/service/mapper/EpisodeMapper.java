package com.rickmorty.service.mapper;

import com.rickmorty.dto.EpisodeDto;
import com.rickmorty.model.Episode;
import org.springframework.stereotype.Component;

@Component
public class EpisodeMapper implements DtoMapper<Episode, EpisodeDto> {

    @Override
    public Episode mapToEntity(EpisodeDto dto) {
        Episode episode = new Episode();
        setEntityFields(episode, dto);
        episode.setAirDate(dto.getAirDate());
        episode.setEpisode(dto.getEpisode());
        return episode;
    }

    @Override
    public EpisodeDto mapToDto(Episode episode) {
        EpisodeDto dto = new EpisodeDto();
        setDtoFields(episode, dto);
        dto.setAirDate(episode.getAirDate());
        dto.setEpisode(episode.getEpisode());
        return dto;
    }
}
