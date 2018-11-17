package com.sonnth.starmanager.service;

import com.sonnth.starmanager.model.Star;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface StarService {
    Page<Star> findAll(Pageable pageable);

    void save(Star star);

    void remove(int id);

    Star findById(int id);

    Page<Star> findByName(String name, Pageable pageable);
}
