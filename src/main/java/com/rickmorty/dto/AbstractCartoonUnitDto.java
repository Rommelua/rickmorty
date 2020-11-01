package com.rickmorty.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rickmorty.service.LocalDateDeserializer;
import java.time.LocalDateTime;

public abstract class AbstractCartoonUnitDto {
    private Long id;
    private String name;
    private String url;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDateTime created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
