package com.rickmorty.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Locations")
public class Location extends AbstractCartoonUnit {
    private String type;
    private String dimension;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }
}
