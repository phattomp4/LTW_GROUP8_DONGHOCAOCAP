package com.vvp.service;

import com.vvp.dao.AccountDAO;
import lombok.RequiredArgsConstructor;
import com.vvp.model.Account;
@RequiredArgsConstructor
public class AccountService {
    private AccountDAO accountDAO = new AccountDAO();

    public com.vvp.model.Account login(String username, String password){
        com.vvp.model.Account acc = accountDAO.findUserByUsername(username);

        if(acc != null && acc.getPassword().equals(password)){
            return acc;
        }
        return null;
    }

    public com.vvp.model.Account findUserByUsername(String username, String password) {

        return accountDAO.findUserByUsername(username);
    }

    public boolean register(String username, String password){
            if(accountDAO.isUsernameExists(username)){
                return false;
            }
            Account account = new Account(username, password, "user");
            return accountDAO.saveAccount(account);
    }

}
