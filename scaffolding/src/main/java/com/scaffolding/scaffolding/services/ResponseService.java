package com.scaffolding.scaffolding.services;

import org.springframework.stereotype.Service;

import com.scaffolding.scaffolding.entities.beans.NumberAccountBean;
import com.scaffolding.scaffolding.entities.beans.ResponseBean;

@Service
public class ResponseService {

    public ResponseBean setResponse(NumberAccountBean numberAccount, String password) {
       
        return new ResponseBean(numberAccount, password);
    }
    
}
