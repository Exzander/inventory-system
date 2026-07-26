package com.iacademy.cselec05.inventory.repo;

import com.iacademy.cselec05.inventory.model.User;

public interface UserRepository {

    // Used for login (finding the username and password of the user in the database)
    User findByCredentials(String username, String password);

    boolean registerUser(User user);
}
