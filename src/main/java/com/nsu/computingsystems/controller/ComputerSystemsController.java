package com.nsu.computingsystems.controller;

import com.nsu.computingsystems.dto.CsEntityHierarchyDto;
import com.nsu.computingsystems.service.CsEntityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cs")
public class ComputerSystemsController {

    private final CsEntityService csEntityService;

    public ComputerSystemsController(CsEntityService csEntityService) {
        this.csEntityService = csEntityService;
    }

    @GetMapping("/all")
    public CsEntityHierarchyDto getCsEntityHierarchy() {
        return csEntityService.getCsEntityHierarchy();
    }

}
