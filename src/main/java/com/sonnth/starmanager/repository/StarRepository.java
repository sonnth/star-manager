package com.sonnth.starmanager.repository;

import com.sonnth.starmanager.model.Star;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StarRepository extends PagingAndSortingRepository<Star, Integer> {
    Page<Star> findAllByNameContaining(String name, Pageable pageable);
}
