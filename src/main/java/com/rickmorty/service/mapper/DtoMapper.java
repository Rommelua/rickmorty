package com.rickmorty.service.mapper;

import com.rickmorty.dto.AbstractCartoonUnitDto;
import com.rickmorty.model.AbstractCartoonUnit;

public interface DtoMapper<T extends AbstractCartoonUnit, U extends AbstractCartoonUnitDto> {
    T mapToEntity(U dto);

    U mapToDto(T entity);

    default void setEntityFields(T entity, U dto) {
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setUrl(dto.getUrl());
        entity.setCreated(dto.getCreated());
    }

    default void setDtoFields(T entity, U dto) {
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setUrl(entity.getUrl());
        dto.setCreated(entity.getCreated());
    }
}
