package com.hair.service;

import com.hair.model.Haircut;
import com.hair.repository.HaircutRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HaircutService {
    private final HaircutRepository haircutRepository;

    public HaircutService(HaircutRepository haircutRepository) {
        this.haircutRepository = haircutRepository;
    }

    public List<Haircut> findAll() {
        return haircutRepository.findAll();
    }

    public Optional<Haircut> findById(Long id) {
        return haircutRepository.findById(id);
    }

    public Optional<Haircut> create(Haircut haircut) {
        return Optional.of(haircutRepository.save(haircut));
    }

    public void delete(Long id) {
        haircutRepository.deleteById(id);
    }

    public Optional<Haircut> update(Haircut haircut) {
        Optional<Haircut> hcut = haircutRepository.findById(haircut.getId());
        if (hcut.isPresent()) {
            hcut.get().setCreatedAt(haircut.getCreatedAt());
            hcut.get().setHairdresserId(haircut.getHairdresserId());
            hcut.get().setCustomerId(haircut.getCustomerId());
            hcut.get().setNameHaircut(haircut.getNameHaircut());

        }
        return hcut;
    }
}
