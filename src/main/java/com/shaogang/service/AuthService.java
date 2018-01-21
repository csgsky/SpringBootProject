package com.shaogang.service;

import com.shaogang.security.CurrentUserHolder;

import org.springframework.stereotype.Service;

/**
 * Created by allen on 18/1/20.
 */
@Service
public class AuthService {

    public void checkAccess() {
        String user = CurrentUserHolder.get();
        if (!"admin".equals(user)){
            throw new RuntimeException("use is not admin");
        }
    }
}
