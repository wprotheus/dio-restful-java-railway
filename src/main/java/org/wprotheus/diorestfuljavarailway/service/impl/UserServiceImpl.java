package org.wprotheus.diorestfuljavarailway.service.impl;

import org.springframework.stereotype.Service;
import org.wprotheus.diorestfuljavarailway.model.User;
import org.wprotheus.diorestfuljavarailway.repository.UserRepository;
import org.wprotheus.diorestfuljavarailway.service.UserService;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber()))
            throw new IllegalArgumentException("An Account Number" +
                    userToCreate.getAccount().getNumber() + " already exists.");
        return userRepository.save(userToCreate);
    }
}
