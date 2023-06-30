package com.scaffolding.scaffolding.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scaffolding.scaffolding.entities.beans.NumberAccountBean;
import com.scaffolding.scaffolding.entities.beans.UserWithAccountBean;
import com.scaffolding.scaffolding.entities.UserEntity;
import com.scaffolding.scaffolding.entities.beans.CreatedUserAccountBean;

@Service
public class ResponseService {

    @Autowired
    AccountService accountService;

    public CreatedUserAccountBean setResponse(NumberAccountBean numberAccount, String password) {
        return new CreatedUserAccountBean(numberAccount, password);
    }

    public UserWithAccountBean getUserWithAccountBean(UserEntity user) {
        return new UserWithAccountBean(user, accountService.getAccount(user.getUid()));
    }
    
}
