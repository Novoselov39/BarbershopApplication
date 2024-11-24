package com.hair.repository;

import com.hair.model.Haircut;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HaircutRepository extends JpaRepository<Haircut, Long> {
    Optional<Haircut> findById(Long id);
}
