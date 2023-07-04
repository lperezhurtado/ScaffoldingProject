package com.scaffolding.scaffolding.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scaffolding.scaffolding.entities.beans.IbanNumberBean;
import com.scaffolding.scaffolding.entities.beans.UserWithAccountBean;
import com.scaffolding.scaffolding.entities.UserEntity;
import com.scaffolding.scaffolding.entities.beans.CreatedUserAccountBean;

@Service
public class ResponseService {

    @Autowired
    AccountService accountService;

    public CreatedUserAccountBean setResponse(IbanNumberBean ibanNumber, String password) {
        return new CreatedUserAccountBean(ibanNumber, password);
    }

    public UserWithAccountBean getUserWithAccountBean(UserEntity user) {
        return new UserWithAccountBean(user, accountService.getAccount(user.getUid()));
    }
    
}
