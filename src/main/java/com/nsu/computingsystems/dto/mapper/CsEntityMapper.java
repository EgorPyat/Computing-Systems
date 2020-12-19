package com.nsu.computingsystems.dto.mapper;

import com.nsu.computingsystems.dto.CsEntityDto;
import com.nsu.computingsystems.model.CsEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CsEntityMapper {

    public List<CsEntityDto> convertHierarchy(final List<CsEntity> rootCsEntities) {
        return rootCsEntities.stream()
                .map(e -> new CsEntityDto(
                        e.getId(),
                        e.getName(),
                        e.getDescription(),
                        convertHierarchy(e.getDescendants())))
                .collect(Collectors.toList());
    }
}
