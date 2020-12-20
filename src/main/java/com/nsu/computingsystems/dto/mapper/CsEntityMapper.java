package com.nsu.computingsystems.dto.mapper;

import com.nsu.computingsystems.dto.CsEntityDto;
import com.nsu.computingsystems.dto.CsEntityHierarchyDto;
import com.nsu.computingsystems.model.CsEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CsEntityMapper {

    public CsEntityHierarchyDto convertHierarchy(final List<CsEntity> entities) {
        var rootEntities = new ArrayList<Long>();
        var entityDtos = entities.stream()
                .map(e -> {
                    if (e.getParents().isEmpty()) {
                        rootEntities.add(e.getId());
                    }
                    return new CsEntityDto(
                            e.getId(),
                            e.getName(),
                            e.getDescription(),
                            e.getParents().stream().map(CsEntity::getId).collect(Collectors.toList()),
                            e.getDescendants().stream().map(CsEntity::getId).collect(Collectors.toList()));
                })
                .collect(Collectors.toMap(e -> e.id, Function.identity()));
        return new CsEntityHierarchyDto(rootEntities, entityDtos);
    }

}
