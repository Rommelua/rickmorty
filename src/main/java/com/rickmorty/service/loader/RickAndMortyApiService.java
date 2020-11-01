package com.rickmorty.service.loader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rickmorty.dto.AbstractCartoonUnitDto;
import com.rickmorty.dto.ApiResponseDto;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RickAndMortyApiService {
    public <T extends AbstractCartoonUnitDto> List<T> getCartoonUnits(
            String link, TypeReference<ApiResponseDto<T>> typeReference) {
        List<T> unitList = new ArrayList<>();
        ApiResponseDto<T> apiResponse = getApiResponse(link, typeReference);
        unitList.addAll(apiResponse.getUnits());
        String nextPage = apiResponse.getInfo().getNext();
        if (nextPage != null) {
            unitList.addAll(getCartoonUnits(nextPage, typeReference));
        }
        return unitList;
    }

    private <T extends AbstractCartoonUnitDto> ApiResponseDto<T> getApiResponse(
            String link, TypeReference<ApiResponseDto<T>> typeReference) {
        try {
            URL url = new URL(link);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return objectMapper.readValue(url, typeReference);
        } catch (IOException e) {
            throw new RuntimeException("Can't connect to " + link, e);
        }
    }
}
