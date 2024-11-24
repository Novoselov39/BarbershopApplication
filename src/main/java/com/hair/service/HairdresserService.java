package com.hair.service;

import com.hair.repository.HairdresserRepository;
import com.hair.model.Hairdresser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HairdresserService {
    private final HairdresserRepository hairdresserRepository;

    public HairdresserService(HairdresserRepository hairdresserRepository) {
        this.hairdresserRepository = hairdresserRepository;
    }

    public List<Hairdresser> findAll() {
        return hairdresserRepository.findAll();
    }

    public Optional<Hairdresser> findById(Long id) {
        return hairdresserRepository.findById(id);
    }

    public Optional<Hairdresser> create(Hairdresser hairdresser) {
        return Optional.of(hairdresserRepository.save(hairdresser));
    }

    public void delete(Long id) {
        hairdresserRepository.deleteById(id);
    }

    public Optional<Hairdresser> update(Hairdresser hairdresser) {
        Optional<Hairdresser> hdreser = hairdresserRepository.findById(hairdresser.getId());
        if (hdreser.isPresent()) {
            hdreser.get().setName(hairdresser.getName());
//            hdreser.get().setLogin(hairdresser.getLogin());
            hdreser.get().setPhone(hairdresser.getPhone());
//            hdreser.get().setPassword(hairdresser.getPassword());

        }
        return hdreser;
    }
}
