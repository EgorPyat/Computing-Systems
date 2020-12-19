package com.nsu.computingsystems.service;

import com.nsu.computingsystems.dto.CsEntityDto;
import com.nsu.computingsystems.dto.mapper.CsEntityMapper;
import com.nsu.computingsystems.repository.CsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CsEntityService {

    private final CsRepository csRepository;
    private final CsEntityMapper csEntityMapper;

    public CsEntityService(final CsRepository csRepository, final CsEntityMapper csEntityMapper) {
        this.csRepository = csRepository;
        this.csEntityMapper = csEntityMapper;
    }

    @Transactional
    public List<CsEntityDto> getCsEntityHierarchy() {
        return csEntityMapper.convertHierarchy(csRepository.findAllByParentIdIsNull());
    }
}
