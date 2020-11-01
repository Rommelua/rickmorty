package com.rickmorty.dto;

import java.time.LocalDate;

public class EpisodeDto extends AbstractCartoonUnitDto {
    private LocalDate airDate;
    private String episode;

    public LocalDate getAirDate() {
        return airDate;
    }

    public void setAirDate(LocalDate airDate) {
        this.airDate = airDate;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }
}
