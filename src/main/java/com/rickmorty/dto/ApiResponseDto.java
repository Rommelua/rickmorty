package com.rickmorty.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class ApiResponseDto<T extends AbstractCartoonUnitDto> {
    private InfoApiResponseDto info;
    @JsonProperty("results")
    private List<T> units;

    public InfoApiResponseDto getInfo() {
        return info;
    }

    public void setInfo(InfoApiResponseDto info) {
        this.info = info;
    }

    public List<T> getUnits() {
        return units;
    }

    public void setUnits(List<T> units) {
        this.units = units;
    }
}
