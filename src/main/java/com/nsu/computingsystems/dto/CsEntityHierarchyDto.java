package com.nsu.computingsystems.dto;

import java.util.List;
import java.util.Map;

public class CsEntityHierarchyDto {
    public List<Long> rootEntities;
    public Map<Long, CsEntityDto> entities;

    public CsEntityHierarchyDto(final List<Long> rootEntities, final Map<Long, CsEntityDto> entities) {
        this.rootEntities = rootEntities;
        this.entities = entities;
    }
}
