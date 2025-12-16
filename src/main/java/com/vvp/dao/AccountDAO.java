package com.dao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountDAO{

    public com.model.Account findUserByUsername(String username) {
        if("vu".equalsIgnoreCase(username)){
            return new com.model.Account("vu", "123", "ADMIN");
        }
        return null;
    }

}
