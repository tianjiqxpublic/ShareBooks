package com.tianjiqx.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by tianjiqx on 2017/6/25.
 */
@Entity
public class Share {
    @Id
    @GeneratedValue
    private Integer id;

    private String tile;
    private String sharer;
    private String description;

    public Share() {
        super();
    }

    public Share(String tile) {
        this.tile = tile;
    }

    public Share(String sharer, String description) {
        this.sharer = sharer;
        this.description = description;
    }

    public Share(String tile, String sharer, String description) {
        this.tile = tile;
        this.sharer = sharer;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTile() {
        return tile;
    }

    public void setTile(String tile) {
        this.tile = tile;
    }

    public String getSharer() {
        return sharer;
    }

    public void setSharer(String sharer) {
        this.sharer = sharer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

