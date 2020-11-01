package com.rickmorty.service.loader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.rickmorty.dto.AbstractCartoonUnitDto;
import com.rickmorty.dto.ApiResponseDto;
import java.util.List;

public interface RickAndMortyApiService {
    <T extends AbstractCartoonUnitDto> List<T> getCartoonUnits(
            String link, TypeReference<ApiResponseDto<T>> typeReference);
}
