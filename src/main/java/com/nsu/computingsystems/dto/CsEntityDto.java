package com.nsu.computingsystems.dto;

import java.util.List;

public class CsEntityDto {

    public Long id;
    public String name;
    public String description;
    public List<Long> parents;
    public List<Long> descendants;

    public CsEntityDto(final Long id,
                       final String name,
                       final String description,
                       final List<Long> parents,
                       final List<Long> descendants) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.parents = parents;
        this.descendants = descendants;
    }
}
