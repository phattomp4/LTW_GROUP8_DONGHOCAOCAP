package com.Service;

import com.dao.AccountDAO;
import com.model.Account;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountService {
    private AccountDAO accountDAO = new AccountDAO();

    public Account login(String username, String password){
        Account acc = accountDAO.findUserByUsername(username);

        if(acc != null && acc.getPassword().equals(password)){
            return acc;
        }
        return null;
    }

    public Account findUserByUsername(String username) {
        return accountDAO.findUserByUsername(username);
    }
}
