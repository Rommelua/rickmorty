package com.rickmorty.service.loader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.rickmorty.dto.EpisodeDto;
import com.rickmorty.model.Episode;
import com.rickmorty.repository.EpisodeRepository;
import com.rickmorty.service.mapper.EpisodeMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EpisodeLoadServiceImpl implements EpisodeLoadService {
    private final EpisodeMapper mapper;
    private final EpisodeRepository repository;
    private final RickAndMortyApiService apiService;

    @Value("${episodes}")
    private String locationApiUrl;

    @Autowired
    public EpisodeLoadServiceImpl(EpisodeMapper mapper, EpisodeRepository repository,
                                  RickAndMortyApiService apiService) {
        this.mapper = mapper;
        this.repository = repository;
        this.apiService = apiService;
    }

    @Override
    public void loadEpisodes() {
        List<EpisodeDto> dtos = apiService.getCartoonUnits(locationApiUrl, new TypeReference<>() {
        });
        List<Episode> locations = dtos.stream()
                .map(mapper::mapToEntity)
                .collect(Collectors.toList());
        repository.saveAll(locations);
    }
}
