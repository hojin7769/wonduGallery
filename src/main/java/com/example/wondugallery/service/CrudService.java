package com.example.wondugallery.service;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CrudService<RESPONSE,REQUEST> {
    @Transactional(readOnly = true)
    List<RESPONSE> findAll(REQUEST request, Pageable pageable);
    @Transactional(readOnly = true)
    RESPONSE findById (Long id);
    @Transactional
    RESPONSE insert(REQUEST request);
    @Transactional
    RESPONSE update(REQUEST request);
    @Transactional
    void delete(REQUEST request);


}
