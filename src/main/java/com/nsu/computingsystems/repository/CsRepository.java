package com.nsu.computingsystems.repository;

import com.nsu.computingsystems.model.CsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CsRepository extends JpaRepository<CsEntity, Long> {

    List<CsEntity> findAllByParentsIsNull();
}
