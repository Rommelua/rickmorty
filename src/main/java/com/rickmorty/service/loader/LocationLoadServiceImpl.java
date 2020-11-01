package com.rickmorty.service.loader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.rickmorty.dto.LocationDto;
import com.rickmorty.model.Location;
import com.rickmorty.repository.LocationRepository;
import com.rickmorty.service.mapper.LocationMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LocationLoadServiceImpl implements LocationLoadService {
    private final LocationMapper mapper;
    private final LocationRepository repository;
    private final RickAndMortyApiService apiService;

    @Value("${locations}")
    private String locationApiUrl;

    @Autowired
    public LocationLoadServiceImpl(LocationMapper mapper, LocationRepository repository,
                                   RickAndMortyApiService apiService) {
        this.mapper = mapper;
        this.repository = repository;
        this.apiService = apiService;
    }

    @Override
    public void loadLocations() {
        List<LocationDto> dtos = apiService.getCartoonUnits(locationApiUrl, new TypeReference<>() {
        });
        List<Location> locations = dtos.stream()
                .map(mapper::mapToEntity)
                .collect(Collectors.toList());
        repository.saveAll(locations);
    }
}
