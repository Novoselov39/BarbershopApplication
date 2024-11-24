package com.hair.repository;

import com.hair.model.Hairdresser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HairdresserRepository extends JpaRepository<Hairdresser, Long> {
    Optional<Hairdresser> findById(Long id);
}
