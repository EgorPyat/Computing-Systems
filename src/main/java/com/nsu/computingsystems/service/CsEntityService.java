package com.nsu.computingsystems.service;

import com.nsu.computingsystems.dto.CsEntityHierarchyDto;
import com.nsu.computingsystems.dto.mapper.CsEntityMapper;
import com.nsu.computingsystems.repository.CsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CsEntityService {

    private final CsRepository csRepository;
    private final CsEntityMapper csEntityMapper;

    public CsEntityService(final CsRepository csRepository, final CsEntityMapper csEntityMapper) {
        this.csRepository = csRepository;
        this.csEntityMapper = csEntityMapper;
    }

    @Transactional
    public CsEntityHierarchyDto getCsEntityHierarchy() {
        return csEntityMapper.convertHierarchy(csRepository.findAll());
    }
}
