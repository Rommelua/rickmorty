package com.rickmorty.service.mapper;

import com.rickmorty.dto.LocationDto;
import com.rickmorty.model.Location;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper implements DtoMapper<Location, LocationDto> {
    public Location mapToEntity(LocationDto dto) {
        Location location = new Location();
        setEntityFields(location, dto);
        location.setDimension(dto.getDimension());
        location.setType(dto.getType());
        return location;
    }

    @Override
    public LocationDto mapToDto(Location location) {
        LocationDto dto = new LocationDto();
        setDtoFields(location, dto);
        dto.setDimension(location.getDimension());
        dto.setType(location.getType());
        return dto;
    }
}
