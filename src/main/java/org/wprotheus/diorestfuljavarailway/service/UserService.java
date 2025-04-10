package org.wprotheus.diorestfuljavarailway.service;

import org.wprotheus.diorestfuljavarailway.model.User;

public interface UserService {
    User findById(Long id);

    User create(User userToCreate);
}
