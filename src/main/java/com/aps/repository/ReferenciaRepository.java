package com.aps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.aps.domain.Referencias;

public interface ReferenciaRepository extends JpaRepository<Referencias, Long>, JpaSpecificationExecutor<Referencias> {

}
