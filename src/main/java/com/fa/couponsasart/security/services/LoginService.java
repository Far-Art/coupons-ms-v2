package com.fa.couponsasart.security.services;

import com.fa.couponsasart.security.exceptions.SecurityException;

public interface LoginService {

    void login(String email, String password) throws SecurityException;

    void signup(String email, String password) throws SecurityException;

    boolean isUserExists(String email, String password) throws SecurityException;
}
