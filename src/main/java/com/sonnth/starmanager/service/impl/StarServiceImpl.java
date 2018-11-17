package com.sonnth.starmanager.service.impl;

import com.sonnth.starmanager.model.Star;
import com.sonnth.starmanager.repository.StarRepository;
import com.sonnth.starmanager.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StarServiceImpl implements StarService {

    @Autowired
    private StarRepository starRepository;

    @Override
    public Page<Star> findAll(Pageable pageable) {
        return starRepository.findAll(pageable);
    }

    @Override
    public void save(Star star) {
        starRepository.save(star);
    }

    @Override
    public void remove(int id) {
        starRepository.deleteById(id);
    }

    @Override
    public Star findById(int id) {
        return starRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Star> findByName(String name, Pageable pageable) {
        return starRepository.findAllByNameContaining(name, pageable);
    }
}
