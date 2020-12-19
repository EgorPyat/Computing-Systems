package com.nsu.computingsystems.dto;

import java.util.List;

public class CsEntityDto {

    public Long id;
    public String name;
    public String description;
    public List<CsEntityDto> descendants;

    public CsEntityDto(final Long id, final String name, final String description, final List<CsEntityDto> descendants) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.descendants = descendants;
    }
}
