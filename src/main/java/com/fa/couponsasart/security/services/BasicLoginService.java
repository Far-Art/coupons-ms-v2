package com.fa.couponsasart.security.services;

import com.fa.couponsasart.domain.beans.UserRole;
import com.fa.couponsasart.security.exceptions.SecurityException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasicLoginService implements LoginService {

    // TODO implement methods

//    private final SessionManager sessionManager;

    @Override
    public void login(String email, String password) throws SecurityException {

    }

    @Override
    public void signup(String email, String password, UserRole role) throws SecurityException {
        System.out.printf("LOGIN SUCCESS email=%s password=%s role=%s\n", email, password, role);
    }

    @Override
    public boolean isUserExists(String email, String password) throws SecurityException {
        return false;
    }
}
