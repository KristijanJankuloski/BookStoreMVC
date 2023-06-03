package com.chrissj.bookstore.service;

import com.chrissj.bookstore.model.User;

public interface AuthService {
    User getCurrentUser();
    String getCurrentUserId();
    User signUpUser(String username, String password, String repeatedPassword);
}
