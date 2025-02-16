package com.hair.service;

import com.hair.repository.UserRepository;
import com.hair.security.User;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> create(User user) {
        return Optional.of(userRepository.save(user));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> update(User user) {
        Optional<User> use = userRepository.findById(user.getId());
        if (use.isPresent()) {
            use.get().setLogin(user.getLogin());
            use.get().setPassword(user.getPassword());
        }
        return use;
    }
}
