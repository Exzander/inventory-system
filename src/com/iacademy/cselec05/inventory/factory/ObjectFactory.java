package com.iacademy.cselec05.inventory.factory;

import com.iacademy.cselec05.inventory.repo.UserRepository;
import com.iacademy.cselec05.inventory.repo.impl.UserJdbcRepository;

public class ObjectFactory {

    private static final UserRepository USER_REPOSITORY = new UserJdbcRepository();

    public static UserRepository getUserRepository() {
        return USER_REPOSITORY;
    }
}
