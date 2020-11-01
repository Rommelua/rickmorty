package com.rickmorty.dto;

import java.util.List;

public class CharacterDto extends AbstractCartoonUnitDto {
    private String status;
    private String species;
    private String type;
    private String gender;
    private LocationInCharacterDto origin;
    private LocationInCharacterDto location;
    private String image;
    private List<String> episode;

    public static class LocationInCharacterDto {
        private String name;
        private String url;

        public LocationInCharacterDto() {
        }

        public LocationInCharacterDto(String name, String url) {
            this.name = name;
            this.url = url;
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
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocationInCharacterDto getOrigin() {
        return origin;
    }

    public void setOrigin(LocationInCharacterDto origin) {
        this.origin = origin;
    }

    public LocationInCharacterDto getLocation() {
        return location;
    }

    public void setLocation(LocationInCharacterDto location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getEpisode() {
        return episode;
    }

    public void setEpisode(List<String> episode) {
        this.episode = episode;
    }
}
